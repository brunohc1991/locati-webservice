package com.locati.webservice.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> fields = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, Long timeStamp) {
		super(status, msg, timeStamp);
	}
	
	public List<FieldMessage> getErrors() {
		return fields;
	}
	
	public void addError(String fieldName, String message) {
		fields.add(new FieldMessage(fieldName, message));
	}

}
