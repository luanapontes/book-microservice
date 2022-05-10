package com.microservice.book.test.builder;

import com.microservice.book.bookmicroservice.category.Category;

public class CategoryBuilder {

    public static Category.CategoryBuilder createCategory(){
        return Category.builder()
                .id(2L)
                .name("Mangá");
    }
}
