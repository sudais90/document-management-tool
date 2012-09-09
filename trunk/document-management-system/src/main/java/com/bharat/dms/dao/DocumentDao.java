package com.bharat.dms.dao;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.multipart.MultipartFile;

import com.bharat.dms.domain.Metadata;
import com.bharat.dms.domain.User;

public interface DocumentDao {

	public List<Metadata> getDocuments(int count, String username, Collection<GrantedAuthority> roles);
	
	public Metadata getDocumentById(Long docId);
	
	public List<Metadata> getDocumentsBySearchQuery(String searchQuery);
	
	public void deleteDocument(Long documentId);
	
	public Long getAllDocumentCount();
	
	public void saveFileToRepo(MultipartFile multipartFile, String fileStorePath, Metadata metadata) throws IOException;
	
	public List<User> getAllUsers();
}
