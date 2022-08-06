package com.fridgerescuer.springboot.data.repository;

import com.fridgerescuer.springboot.data.entity.Ingredient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ComponentScan(basePackages = "com.fridgerescuer.springboot")
@DataMongoTest
class IngredientRepositoryTest {
    @Autowired
    private IngredientRepository ingredientRepository;

    @BeforeEach
    void beforeEach() {  //모두 롤백
        ingredientRepository.deleteAll();
    }

    @Test
    @DisplayName("이름으로 재료 id 찾기")
    void findIngredientIdByName(){
        Ingredient ingredient = Ingredient.builder().name("마늘").type("채소").build();

        Ingredient savedIngredient = ingredientRepository.save(ingredient);
        String name = savedIngredient.getName();

        Ingredient findIngredient = ingredientRepository.findByName(name);

        Assertions.assertThat(findIngredient.getId()).isEqualTo(savedIngredient.getId());
    }
}