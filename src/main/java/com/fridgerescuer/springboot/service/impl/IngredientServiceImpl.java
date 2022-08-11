package com.fridgerescuer.springboot.service.impl;

import com.fridgerescuer.springboot.data.dao.IngredientDao;
import com.fridgerescuer.springboot.data.dto.IngredientDTO;
import com.fridgerescuer.springboot.data.dto.IngredientResponseDTO;
import com.fridgerescuer.springboot.data.entity.Ingredient;
import com.fridgerescuer.springboot.data.mapper.IngredientMapper;
import com.fridgerescuer.springboot.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private final IngredientDao ingredientDao;  //언제든지 구현체를 대체가능하게 변경

    @Override
    public IngredientResponseDTO saveIngredient(IngredientDTO ingredientDTO){

        Ingredient savedIngredient = ingredientDao.save(IngredientMapper.INSTANCE.ingredientDTOToIngredient(ingredientDTO));

        return IngredientMapper.INSTANCE.ingredientToIngredientResponseDTO(savedIngredient);
    }

    @Override
    public IngredientResponseDTO findIngredientByName(String name) {
        Ingredient findIngredient = ingredientDao.findByName(name);
        return IngredientMapper.INSTANCE.ingredientToIngredientResponseDTO(findIngredient);
    }
}
