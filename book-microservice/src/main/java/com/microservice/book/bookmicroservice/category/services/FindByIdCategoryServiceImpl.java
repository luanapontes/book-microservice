package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class FindByIdCategoryServiceImpl implements FindByIdCategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(
                () ->
                        new ObjectNotFoundException("Object not found"));
    }
}
