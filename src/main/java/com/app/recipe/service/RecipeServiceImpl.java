package com.app.recipe.service;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipe.data.RecipeRepository;
import com.app.recipe.data.RecipeSearchPredicateBuilder;
import com.app.recipe.entities.RecipeEntity;
import com.app.recipe.exception.RecordNotFoundException;
import com.app.recipe.model.RecipeData;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.util.StringUtils;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	protected RecipeRepository recipeSpecificationRepository;

	@Autowired
	private ModelMapper modelMapper;

	

	
	@Override	
	public RecipeData addRecipe(RecipeData recipeData) {
		RecipeEntity recipeEntity = modelMapper.map(recipeData, RecipeEntity.class);
		recipeEntity=recipeSpecificationRepository.save(recipeEntity);
		RecipeData recipeDTO = modelMapper.map(recipeEntity, RecipeData.class);
		return recipeDTO;

	}

	@Override
	@Transactional
	public RecipeData modifyRecipe(RecipeData recipeData) {
		RecipeEntity recipeEntity = recipeSpecificationRepository.findById(recipeData.getId())
				.orElseThrow(() -> new RecordNotFoundException("Recipe Id '" + recipeData.getId() + "' not Exists"));	
		modelMapper.map(recipeData, recipeEntity);		
		recipeSpecificationRepository.save(recipeEntity);
		RecipeData recipeDTO = modelMapper.map(recipeEntity, RecipeData.class);
		return recipeDTO;
	}

	@Override
	@Transactional
	public Map<String,Boolean> removeRecipe(Integer recipeId) {
		
		RecipeEntity recipeEntity = recipeSpecificationRepository.findById(recipeId)
				.orElseThrow(() -> new RecordNotFoundException("Recipe Id '" + recipeId + "' not Exists"));		
		
		recipeSpecificationRepository.delete(recipeEntity);
		 Map<String, Boolean> response = new HashMap<>();		 
	     response.put("DELETED", Boolean.TRUE);
	     
		return response;
	}

	@Override
	@Transactional
	public RecipeData getRecipe(Integer recipeId) {
		RecipeEntity recipeEntity = recipeSpecificationRepository.findById(recipeId)
				.orElseThrow(() -> new RecordNotFoundException("Recipe Id '" + recipeId + "' not Exists"));
		RecipeData recipeDTO = modelMapper.map(recipeEntity, RecipeData.class);
		return recipeDTO;

	}
	

	@Override
	@Transactional
	public List<RecipeData> findRecipes(String searchRequest) {
		List<RecipeData> postDtoList = null;
		if (StringUtils.isNullOrEmpty(searchRequest)) {
			List<RecipeEntity> recipeEntityList = recipeSpecificationRepository.findAll();
			Type listType = new TypeToken<List<RecipeData>>() {
			}.getType();
			postDtoList = modelMapper.map(recipeEntityList, listType);
			return postDtoList;
		} else {
			RecipeSearchPredicateBuilder builder = new RecipeSearchPredicateBuilder();
			if (searchRequest != null) {
				Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
				Matcher matcher = pattern.matcher(searchRequest + ",");
				while (matcher.find()) {
					builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
				}
			}
			BooleanExpression exp = builder.build();
			Iterable<RecipeEntity> recipeEntity = recipeSpecificationRepository.findAll(exp);
			List<RecipeEntity> recipeEntityList = StreamSupport.stream(recipeEntity.spliterator(), false)
					.collect(Collectors.toList());
			Type listType = new TypeToken<List<RecipeData>>() {
			}.getType();
			postDtoList = modelMapper.map(recipeEntityList, listType);
			return postDtoList;
		}

	}

	

}
