package com.bharat.dms.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DOCUMENTS")
public class Document {

	private Long documentId;
	private Metadata metadata;
	private byte[] document;


	public Document() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DOCUMENT_ID")
	public Long getDocumentId() {
		return documentId;
	}
	
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	
	@Column(name = "DOCUMENT")
	public byte[] getDocument() {
		return document;
	}
	
	public void setDocument(byte[] document) {
		this.document = document;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "METADATA_ID")
	public Metadata getMetadata() {
		return metadata;
	}
	
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	

}
