package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;

@FunctionalInterface
public interface FindByIdBookService {

    public Book findById(Long id);
}
