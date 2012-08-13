package com.bharat.dms.web.formBean;

import java.util.Arrays;

import com.bharat.dms.domain.Category;

public class DocumentPostFormBean {

	private String subject;
	private Integer category;
	private String keywords;
	private String comments;
	
	
	public DocumentPostFormBean() {
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

//	public byte[] getDocument() {
//		return document;
//	}
//
//	public void setDocument(byte[] document) {
//		this.document = document;
//	}

	@Override
	public String toString() {
		return "DocumentPostFormBean [category=" + category + ", comments="
				+ comments + ", keywords=" + keywords + ", subject=" + subject + "]";
	}
	
	
}
