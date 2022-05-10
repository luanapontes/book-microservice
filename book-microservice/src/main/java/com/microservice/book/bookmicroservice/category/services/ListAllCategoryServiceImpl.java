package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListAllCategoryServiceImpl implements ListAllCategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listAll(){
        return categoryRepository.findAll();
    }
}
