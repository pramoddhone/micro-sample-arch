package com.nitor.skill.web.rest.errors;

public enum ErrorRestResponseCode {

	ROLE_NOT_FOUND("1001"),
	CATEGORY_NOT_FOUND("1002");

	private final String status;

	private ErrorRestResponseCode(final String status) {
		this.status = status;
	}

	public String getCode() {
		return this.status;
	}

}
