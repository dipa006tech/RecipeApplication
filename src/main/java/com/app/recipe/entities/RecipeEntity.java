package com.app.recipe.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="RECIPE")
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "RECIPE_NAME")
	private String recipeName;
	
	@Column(name = "NO_OF_SERVINGS")
	private Integer noOfServings;
	
	@Column(name = "INGRDIENTS")
	private String ingredients;
	
	@Column(name = "IS_VEGERATIAN")
	private String isVegetarian;
	
	@Column(name = "INSTRUCTIONS")
	private String instructions;	
	

}
