package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookRepository;
import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class InsertBookServiceImpl implements InsertBookService{

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Book insert(Book obj){
        for (Category cat: obj.getCategories()) {
            this.categoryRepository.save(cat);
        }
        obj.setSpecificID(UUID.randomUUID().toString());
        return bookRepository.save(obj);
    }
}
