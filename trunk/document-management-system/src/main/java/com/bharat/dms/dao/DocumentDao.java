package com.bharat.dms.dao;

import java.util.List;

import com.bharat.dms.domain.Document;
import com.bharat.dms.domain.Metadata;

public interface DocumentDao {

	public int saveDocument(Document document, Metadata metadata);
	
	public List<Metadata> getDocuments(int count);
	
	public Metadata getDocumentById(Long docId);
	
	public List<Metadata> getDocumentsBySearchQuery(String searchQuery);
}
