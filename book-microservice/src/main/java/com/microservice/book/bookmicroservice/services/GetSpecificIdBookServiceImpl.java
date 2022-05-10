package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetSpecificIdBookServiceImpl implements GetSpecificIdBookService{

    private final BookRepository bookRepository;
    @Override
    public Book findBySpecificID(String specificID) {
        return bookRepository.findBySpecificID(specificID).orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));
    }
}
