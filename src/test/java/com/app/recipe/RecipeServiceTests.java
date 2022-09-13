package com.app.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.recipe.data.RecipeRepository;
import com.app.recipe.entities.RecipeEntity;
import com.app.recipe.model.RecipeData;
import com.app.recipe.service.RecipeService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RecipeServiceTests {

	@Autowired
	private RecipeService recipeService;

	@MockBean
	private RecipeRepository recipeRepository;

	@Test
	@DisplayName("Add Recipe")
	public void addRecipeTest() {

		when(recipeRepository.save(getCakeRecipeEntity())).thenReturn(getCakeRecipeEntity());
		assertEquals(getCakeRecipeDataEntity(), recipeService.addRecipe(getCakeRecipeDataEntity()));

	}

	private RecipeData getCakeRecipeDataEntity() {
		RecipeData recipeEntity = new RecipeData();

		recipeEntity.setId(6);
		recipeEntity.setRecipeName("Cake");
		recipeEntity.setNoOfServings(6);
		recipeEntity.setIngredients("Flour, Honey, yeast");
		recipeEntity.setIsVegetarian("Y");
		recipeEntity.setInstructions("Prepared in Stove");

		return recipeEntity;
	}

	private RecipeEntity getCakeRecipeEntity() {
		RecipeEntity recipeEntity = new RecipeEntity();

		recipeEntity.setId(6);
		recipeEntity.setRecipeName("Cake");
		recipeEntity.setNoOfServings(6);
		recipeEntity.setIngredients("Flour, Honey, yeast");
		recipeEntity.setIsVegetarian("Y");
		recipeEntity.setInstructions("Prepared in Stove");

		return recipeEntity;
	}

}
