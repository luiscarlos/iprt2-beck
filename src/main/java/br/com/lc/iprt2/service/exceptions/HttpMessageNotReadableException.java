package br.com.lc.iprt2.service.exceptions;

public class HttpMessageNotReadableException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	
	public HttpMessageNotReadableException(String message, Throwable cause) {
		super(message, cause);
	
	}

	
	public HttpMessageNotReadableException(String message) {
		super(message);
	
	}
	
	

}
