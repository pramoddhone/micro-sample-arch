package com.nitor.skill.utils;

public class Response<T> {

	private T data;

	public Response(T data) {
		this.data = data;
	}

	public Response() {

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
