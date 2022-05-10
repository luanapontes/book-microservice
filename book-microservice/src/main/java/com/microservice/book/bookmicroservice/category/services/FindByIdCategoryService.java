package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;

@FunctionalInterface
public interface FindByIdCategoryService {

    public Category findById(Long id);
}
