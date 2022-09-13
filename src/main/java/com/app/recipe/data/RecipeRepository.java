package com.app.recipe.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;

import com.app.recipe.entities.QRecipeEntity;
import com.app.recipe.entities.RecipeEntity;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

public interface RecipeRepository
		extends JpaRepository<RecipeEntity, Integer>, QuerydslPredicateExecutor<RecipeEntity>,
		QuerydslBinderCustomizer<QRecipeEntity> {
	
	@Override
    default public void customize(final QuerydslBindings bindings, final QRecipeEntity recipeEntity) {
        bindings.bind(String.class)
          .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
        
    }

}
