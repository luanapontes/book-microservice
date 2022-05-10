package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;

@FunctionalInterface
public interface InsertBookService {

    public Book insert(Book obj);

}
