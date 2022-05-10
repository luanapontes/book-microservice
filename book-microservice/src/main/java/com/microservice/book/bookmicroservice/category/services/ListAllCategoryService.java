package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.Category;

import java.util.List;

@FunctionalInterface
public interface ListAllCategoryService {

    public List<Category> listAll();
}
