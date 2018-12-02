package com.uracle.VO;

import java.sql.Date;

public class BoardVO {
	
	private int id;
	private String title;
	private String body;
	private Date regDate;
	private String writer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "BoardVO [id=" + id + ", title=" + title + ", body=" + body + ", regDate=" + regDate + ", writer="
				+ writer + "]";
	}
		
}
