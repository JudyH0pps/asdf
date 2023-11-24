package com.ssafy.camp.model.dto;

public class Review {
	int id;
	String userKey;
	int campKey;
	String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
