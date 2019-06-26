package com.nitor.skill.web.rest.errors;

public class ErrorDetails {

	private long timestamp;
	private int status;
	private String title;
	private String details;

	public ErrorDetails() {

	}

	public ErrorDetails(long timestamp, int status, String title, String details) {
		this.timestamp = timestamp;
		this.status = status;
		this.title = title;
		this.details = details;

	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
