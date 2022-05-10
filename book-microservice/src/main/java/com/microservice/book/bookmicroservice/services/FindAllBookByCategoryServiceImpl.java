package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FindAllBookByCategoryServiceImpl implements FindAllBookByCategoryService{

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAllBookByCategoryName(String categoryName) {
        return bookRepository.findBookByCategoriesName(categoryName);
    }
}
