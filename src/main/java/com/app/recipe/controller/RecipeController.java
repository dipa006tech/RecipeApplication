package com.app.recipe.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.app.recipe.model.RecipeData;
import com.app.recipe.service.RecipeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/recipes")
@Api(tags = "Recipe App")
public class RecipeController {
	
	protected Logger logger;

	public RecipeController() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@Autowired
	RecipeService recipeService;
	
	/**
	 * 
	 * @param recipeEntity
	 * @return {@link ResponseEntity}
	 */
	@ApiOperation(value = "Add Recipe", notes = "This service add Recipe for user")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping
	public ResponseEntity<RecipeData> addRecipe(@Valid @RequestBody RecipeData recipeData) {

		RecipeData recipeDTO=recipeService.addRecipe(recipeData);

		return ResponseEntity.ok(recipeDTO);
	}
	
	
	
	/**
	 * 
	 * @param recipeEntity
	 * @param updateType
	 * @return {@link ResponseEntity}
	 */
	@GetMapping(value = "/{recipeId}")
	@ApiOperation(value = "Gets Recipe", notes = "This service will gets an Recipe for user")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<RecipeData> getRecipe(@PathVariable Integer recipeId) {
		logger.info("Get the Recipe..");	
		RecipeData recipeDTO=recipeService.getRecipe(recipeId);
		return ResponseEntity.ok(recipeDTO);
	}
	
	/**
	 * 
	 * @param recipeEntity
	 * @param updateType
	 * @return {@link ResponseEntity}
	 */
	@PutMapping(value = "/{recipeId}")
	@ApiOperation(value = "Modify Recipe", notes = "This service will updates an Recipe for user")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<RecipeData> modifyRecipe(@Valid @RequestBody RecipeData recipeData, @PathVariable Integer recipeId) {
		recipeData.setId(recipeId);
		RecipeData recipeDTO=recipeService.modifyRecipe(recipeData);
		return ResponseEntity.ok(recipeDTO);
	}
	
	/**
	 * 
	 * @param recipeEntity
	 * @param updateType
	 * @return {@link ResponseEntity}
	 */
	@DeleteMapping(value = "/{recipeId}")
	@ApiOperation(value = "Delete Recipe", notes = "This service will Remove an Recipe for user")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, Boolean>>  removeRecipe(@Valid @PathVariable Integer recipeId) {
		
		
		Map<String,Boolean> responseMap= recipeService.removeRecipe(recipeId);
		
		return ResponseEntity.ok(responseMap);
		
	}
	
	
	
	/**
	 * 
	 * @param recipeEntity
	 * @param updateType
	 * @return {@link ResponseEntity}
	 */
	@ApiOperation(value = "Find Recipe", notes = "This service will Gets recipes based on your search")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/findRecipes")
	public ResponseEntity<List<RecipeData>> findRecipes(@RequestParam(value = "search", required = false) String searchRequest) {

		List<RecipeData> recipies = recipeService.findRecipes(searchRequest);

		return ResponseEntity.ok(recipies);
	}	
	
	
	
}
