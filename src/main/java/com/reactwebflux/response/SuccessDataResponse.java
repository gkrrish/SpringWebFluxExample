package com.reactwebflux.response;

public class SuccessDataResponse<T> extends Response {
	private T data;

	public SuccessDataResponse(T data) {
		super(true);
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	

}
