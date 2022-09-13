package com.app.recipe.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.querydsl.core.types.dsl.BooleanExpression;

public class RecipeSearchPredicateBuilder {
	 private List<RecipeSearchCriteria> params;

	    public RecipeSearchPredicateBuilder() {
	        params = new ArrayList<>();
	    }

	    public RecipeSearchPredicateBuilder with(
	      String key, String operation, Object value) {
	  
	        params.add(new RecipeSearchCriteria(key, operation, value));
	        return this;
	    }

	    public BooleanExpression build() {
	        if (params.size() == 0) {
	            return null;
	        }

	        List<BooleanExpression> predicates = params.stream().map(param -> {
	        	RecipeSearchPredicate predicate = new RecipeSearchPredicate(param);
	            return predicate.getPredicate();
	        }).filter(Objects::nonNull).collect(Collectors.toList());
	        
	        BooleanExpression result = predicates.get(0);
	        for (BooleanExpression predicate : predicates) {
	            result = result.and(predicate);
	        }        
	        return result;
	    }
}
