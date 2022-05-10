package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.BookDTO;

@FunctionalInterface
public interface UpdateBookService {

    public void update(BookDTO bookDTO, Long id);

}
