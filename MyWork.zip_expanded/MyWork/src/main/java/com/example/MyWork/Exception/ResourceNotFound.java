package com.example.MyWork.Exception;

public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFound(String message) {
		super(message);
	}

}
