package com.app.recipe;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.ResponseEntity;

import com.app.recipe.controller.RecipeController;
import com.app.recipe.model.RecipeData;
import com.app.recipe.service.RecipeService;

@ExtendWith(MockitoExtension.class)
public class RecipeControllerTests {

	@Mock
	private RecipeService recipeService;

	@InjectMocks
	private RecipeController recipeController;

	@Test
	@DisplayName("Add Recipe")
	@MockitoSettings(strictness = Strictness.WARN)
	void addRecipeTest() {

		ResponseEntity<RecipeData> responseEntity = recipeController.addRecipe(prepareRecipeforTest().get(0));

		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	private List<RecipeData> prepareRecipeforTest() {
		List<RecipeData> recipeDataList = new ArrayList<>();
		RecipeData recipeData = new RecipeData();
		recipeData.setId(4);
		recipeData.setRecipeName("Pancake");
		recipeData.setNoOfServings(6);
		recipeData.setIngredients("Flour, Honey, yeast");
		recipeData.setIsVegetarian("Y");
		recipeData.setInstructions("Prepared in Stove");
		recipeDataList.add(recipeData);

		return recipeDataList;
	}

	@Test
	@DisplayName("Update Recipe")
	@MockitoSettings(strictness = Strictness.WARN)
	void updateRecipeTest() {
		ResponseEntity<RecipeData> responseEntity = recipeController.modifyRecipe(prepareRecipeforTest().get(0), 6);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	@DisplayName("Update Recipe")
	@MockitoSettings(strictness = Strictness.WARN)
	void deleteRecipeTest() {
		ResponseEntity<Map<String, Boolean>> responseEntity = recipeController.removeRecipe(6);
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

	@Test
	@DisplayName("Update Recipe")
	@MockitoSettings(strictness = Strictness.WARN)
	void displayRecipesTest() {
		ResponseEntity<List<RecipeData>> responseEntity = recipeController.findRecipes("PanCake");
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

	}

}
