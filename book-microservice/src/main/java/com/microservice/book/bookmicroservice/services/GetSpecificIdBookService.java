package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;

@FunctionalInterface
public interface GetSpecificIdBookService {
    Book findBySpecificID(String specificID);
}
