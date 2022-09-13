package com.app.recipe.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRecipeEntity is a Querydsl query type for RecipeEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecipeEntity extends EntityPathBase<RecipeEntity> {

    private static final long serialVersionUID = -1772213416L;

    public static final QRecipeEntity recipeEntity = new QRecipeEntity("recipeEntity");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath ingredients = createString("ingredients");

    public final StringPath instructions = createString("instructions");

    public final StringPath isVegetarian = createString("isVegetarian");

    public final NumberPath<Integer> noOfServings = createNumber("noOfServings", Integer.class);

    public final StringPath recipeName = createString("recipeName");

    public QRecipeEntity(String variable) {
        super(RecipeEntity.class, forVariable(variable));
    }

    public QRecipeEntity(Path<? extends RecipeEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRecipeEntity(PathMetadata metadata) {
        super(RecipeEntity.class, metadata);
    }

}

