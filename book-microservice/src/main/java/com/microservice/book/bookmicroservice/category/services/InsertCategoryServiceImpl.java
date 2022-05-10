package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InsertCategoryServiceImpl implements InsertCategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category insert(Category obj){
        return categoryRepository.save(obj);
    }
}
