package com.nitor.skill.web.rest.errors;

/*
 * 
 * This is an user define exception class which handles Application exceptions
 * */
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	private String message;
	/**
	 * This field represents ErrorCode.
	 * 
	 */
	private int errorCode;

	public ApplicationException() {
	}

	public ApplicationException(final int errorCode, final String message) {
		this.errorCode = errorCode;
		this.setMessage(message);

	}

	public ApplicationException(final String title, final int errorCode, final String message) {
		this.title = title;
		this.errorCode = errorCode;
		this.setMessage(message);
	}

	/**
	 * @return the ErrorCode object
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
