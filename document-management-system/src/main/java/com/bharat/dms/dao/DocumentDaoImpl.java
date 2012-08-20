package com.bharat.dms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.acls.domain.GrantedAuthoritySid;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import com.bharat.dms.domain.Document;
import com.bharat.dms.domain.Metadata;
import com.bharat.dms.utils.Constants;

public class DocumentDaoImpl implements DocumentDao {

	private final Logger log = Logger.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int saveDocument(Document document, Metadata metadata) {
		log.info("Entering saveDocument method in DAO");
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unused")
		Long metadataId = (Long) session.save(metadata);
		session.save(document);
		log.info("Leaving saveDocument method in DAO");
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Metadata> getDocuments(int count, String username,
			Collection<GrantedAuthority> roles) {

		List<Metadata> lst = new ArrayList<Metadata>();

		log.info("Entering getDocuments method in DAO");
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Metadata.class);
		crit.setMaxResults(count);
		crit.addOrder(Order.desc("createdDate"));
		
		GrantedAuthority admin = new GrantedAuthorityImpl(Constants.ROLE_ADMIN);
		GrantedAuthority superAdmin = new GrantedAuthorityImpl(Constants.ROLE_SUPER_ADMIN);
		
		if ((username != null && !username.trim().equals(""))
				&& !(roles.contains(admin) || roles
						.contains(superAdmin))) {

			crit.add(Restrictions.ilike("createUser", username));
		}

		lst = (List<Metadata>) crit.list();
		log.info("Leaving getDocuments method in DAO");
		return lst;
	}

	@Override
	public Metadata getDocumentById(Long docId) {

		Session session = sessionFactory.openSession();
		Metadata meta = (Metadata) session.get(Metadata.class, docId);
		meta.getDocument().getDocument();
		return meta;
	}

	@Override
	public List<Metadata> getDocumentsBySearchQuery(String searchQuery) {

		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Metadata.class);
		crit.add(Restrictions.disjunction().add(
				Restrictions.ilike("documentFileName", searchQuery,
						MatchMode.ANYWHERE))
				.add(
						Restrictions.ilike("keywords", searchQuery,
								MatchMode.ANYWHERE)).add(
						Restrictions.ilike("createUser", searchQuery,
								MatchMode.ANYWHERE)).add(
						Restrictions.ilike("updatedUser", searchQuery,
								MatchMode.ANYWHERE)).add(
						Restrictions.ilike("subject", searchQuery,
								MatchMode.ANYWHERE)).add(
						Restrictions.ilike("comments", searchQuery,
								MatchMode.ANYWHERE)));
		crit.setMaxResults(100);
		crit.addOrder(Order.desc("createdDate"));
		List<Metadata> lst = crit.list();
		int len = lst.size();
		log.info(":::: Search returned " + len + " items.");
		return lst;
	}

	/**
	 * Deletes a document
	 */

	@Override
	public void deleteDocument(Long documentId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Metadata meta = (Metadata) session.get(Metadata.class, documentId);
		session.delete(meta);
		log.info("Is transaction active? = "
				+ session.getTransaction().isActive());
		session.getTransaction().commit();
		log
				.info("document Deleted.<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

	@Override
	public Long getAllDocumentCount() {
		Session session = sessionFactory.openSession();
		Long count = (Long) session.createCriteria(Metadata.class)
				.setProjection(Projections.rowCount()).uniqueResult();

		return count;
	}
}
