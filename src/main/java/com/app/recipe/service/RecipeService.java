package com.app.recipe.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.app.recipe.model.RecipeData;

@Service
public interface RecipeService {

	RecipeData addRecipe(RecipeData recipeData);
	
	RecipeData getRecipe(Integer recipeId);

	RecipeData modifyRecipe(RecipeData recipeData);

	Map<String, Boolean> removeRecipe(Integer recipeId);

	List<RecipeData> findRecipes(String searchRequest);
	

}
