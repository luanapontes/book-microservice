package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListAllBookServiceImpl implements ListAllBookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> listAll(){
        return bookRepository.findAll();
    }
}
