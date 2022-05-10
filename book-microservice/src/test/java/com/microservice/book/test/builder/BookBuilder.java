package com.microservice.book.test.builder;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.category.Category;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {

    public static Book.BookBuilder createBook(){

        List<Category> categories = new ArrayList<>();
        categories.add(new Category(2L, "Mangá"));
        return Book.builder()
                .id(2L)
                .isbn(20)
                .name("Test")
                .author("Luana")
                .yearOfPublication(2021)
                .quantityAvailable(2)
                .resume("Test")
                .categories(categories)
                .sellPrice(20.00);



    }
}
