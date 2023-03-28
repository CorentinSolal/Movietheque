package com.eni.exception;

import java.util.ArrayList;
import java.util.List;

public class MovieException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private List<String> errors;

	public MovieException() {
		super();
		errors = new ArrayList<>();
	}

	public void addError(String msg) {
		errors.add(msg);
	}

	public List<String> getErrors() {
		return errors;
	}

	public boolean isError() {
		return errors.size() > 0;
	}

}
