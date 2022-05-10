package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;

import java.util.List;

@FunctionalInterface
public interface FindAllBookByCategoryService {

    List<Book> findAllBookByCategoryName(String categoryName);
}
