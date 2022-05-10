package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;

@FunctionalInterface
public interface InsertCategoryService {

    public Category insert(Category obj);
}
