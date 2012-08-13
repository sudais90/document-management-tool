package com.bharat.dms.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bharat.dms.dao.DocumentDao;
import com.bharat.dms.domain.Document;
import com.bharat.dms.domain.Metadata;
import com.bharat.dms.web.formBean.DocumentPostFormBean;

public class DocumentService {

	private final Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
	private DocumentDao documentDao;

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Transactional
	public int saveDocument(MultipartFile multipartFile,
			DocumentPostFormBean formBean) {

		log.info("Entering saveDocument method");
		int status = 0;
		try {
			Document document = new Document();
			document.setDocument(multipartFile.getBytes());
			// document.setMetadata(metadata);
			
			Metadata metadata = new Metadata();
			metadata.setComments(formBean.getComments());
			metadata.setCreatedDate(new Date());
			metadata.setCreateUser("Bharat");
			metadata.setKeywords(formBean.getKeywords());
			metadata.setSubject(formBean.getSubject());
			metadata.setDocument(document);
			metadata.setDocumentType(multipartFile.getContentType());
			metadata.setDocumentFileName(multipartFile.getOriginalFilename());
			metadata.setDocumentSize(multipartFile.getSize());
			
			log.info("Content Type :"+multipartFile.getContentType());
			log.info("Name :"+multipartFile.getName());
			log.info("Original File Name :"+multipartFile.getOriginalFilename());
			log.info("Size :"+multipartFile.getSize());
			log.info("Is Empty :"+multipartFile.isEmpty());
			
			status = documentDao.saveDocument(document, metadata);

			log.info("Leaving saveDocument method");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Transactional
	public List<Metadata> getRecentDocuments(){
		List<Metadata> lst = new ArrayList<Metadata>();
		lst = (List<Metadata>) documentDao.getDocuments(50);
		return lst;
	}
	
	public Metadata getDocumentById(Long docId){
		Metadata meta = new Metadata(); 
		
		meta = documentDao.getDocumentById(docId);
		
		return meta;
	}
	
	
	public List<Metadata> getDocumentsBySearchQuery(String searchQuery) {
		List<Metadata> lst = new ArrayList<Metadata>();
		
		lst = documentDao.getDocumentsBySearchQuery(searchQuery);
		return lst;
	}
}
