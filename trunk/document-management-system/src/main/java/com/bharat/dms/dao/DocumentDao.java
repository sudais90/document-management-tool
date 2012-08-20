package com.bharat.dms.dao;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.bharat.dms.domain.Document;
import com.bharat.dms.domain.Metadata;
import com.bharat.dms.domain.UserRole;

public interface DocumentDao {

	public int saveDocument(Document document, Metadata metadata);
	
	public List<Metadata> getDocuments(int count, String username, Collection<GrantedAuthority> roles);
	
	public Metadata getDocumentById(Long docId);
	
	public List<Metadata> getDocumentsBySearchQuery(String searchQuery);
	
	public void deleteDocument(Long documentId);
	
	public Long getAllDocumentCount();
}
