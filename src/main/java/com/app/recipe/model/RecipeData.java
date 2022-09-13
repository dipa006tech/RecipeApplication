package com.app.recipe.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class RecipeData {
	
	
	private Integer id;
	private String recipeName;
	private Integer noOfServings;	
	private String ingredients;	
	private String isVegetarian;	
	private String instructions;

	

}
