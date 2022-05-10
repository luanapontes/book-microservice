package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;

import java.util.List;

@FunctionalInterface
public interface ListAllBookService {

    public List<Book> listAll();
}
