package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FindByIdBookServiceImpl implements FindByIdBookService {

    private final BookRepository bookRepository;

    @Override
    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException("Object not found"));

    }
}
