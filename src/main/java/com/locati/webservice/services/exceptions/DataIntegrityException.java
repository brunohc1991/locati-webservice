package com.locati.webservice.services.exceptions;

public class DataIntegrityException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityException(Class<?> c) {
		super("Não é possível excluir "+ c.getName().split("\\.")[(c.getName().split("\\.").length) - 1] + ", pois possui vínculo.");
	}
	
	public DataIntegrityException(String msg) {
		super(msg);
	}
	
	public DataIntegrityException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
