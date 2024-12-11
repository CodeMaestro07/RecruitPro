package com.jbk.dto;

import java.sql.Timestamp;

public class ExceptionResponce {
	private String message;
	private String path;
	private Timestamp timestamp ;
	
	public ExceptionResponce() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponce(String message, String path, Timestamp timestamp) {
		super();
		this.message = message;
		this.path = path;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setPath(StringBuffer requestURL) {
		// TODO Auto-generated method stub
		
	}
	
}
 