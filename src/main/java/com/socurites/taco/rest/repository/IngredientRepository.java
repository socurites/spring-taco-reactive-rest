package com.socurites.taco.rest.repository;

import com.socurites.taco.rest.model.Ingredient;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, String> {
}
