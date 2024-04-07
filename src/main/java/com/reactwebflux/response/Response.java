package com.reactwebflux.response;

public class Response {
	private boolean success;

	public Response() {
	}

	public Response(boolean success) {
		super();
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
