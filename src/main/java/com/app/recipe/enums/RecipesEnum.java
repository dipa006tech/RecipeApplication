package com.app.recipe.enums;

public enum RecipesEnum {

	VEG("Vegetarian Recipe"), NON_VEG("Non-Vegetarian Recipe"), Y("Y"), N("N");

	private String message;

	private RecipesEnum(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
