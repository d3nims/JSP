package com.sbs.board;

public class Article {
	private int id;
	private String title;
	private String body;
	public String getTitle() {
		return title;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}	
}
