package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.CategoryDTO;

@FunctionalInterface
public interface UpdateCategoryService {

    public void update(CategoryDTO categoryDTO, Long id);
}
