package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryDTO;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateCategoryServiceImpl implements UpdateCategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void update(CategoryDTO categoryDTO, Long id ){
        Category categorySaved = categoryRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));

        categorySaved.setName(categoryDTO.getName());

        categoryRepository.save(categorySaved);

    }
}
