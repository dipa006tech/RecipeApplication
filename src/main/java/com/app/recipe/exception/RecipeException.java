package com.app.recipe.exception;

public class RecipeException extends Exception {
	

	private static final long serialVersionUID = -4344621681437086391L;
	
	public RecipeException(String message) {
		super(message);
	}
	
	public RecipeException(String message, Throwable cause) {
		super(message, cause);
	}

	public RecipeException(Throwable cause) {
		super(cause);
	}

	protected RecipeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
