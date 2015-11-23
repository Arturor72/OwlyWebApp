package com.owly.helper;

public class OwlyException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String errorMessage;

	public OwlyException(String errorMessage, String errorCode) {
		this.errorCode=errorCode;
		this.errorCode=errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
	
}

