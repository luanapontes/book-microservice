package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.Book;
import com.microservice.book.bookmicroservice.BookDTO;
import com.microservice.book.bookmicroservice.BookRepository;
import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateBookServiceImpl implements  UpdateBookService{

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public void update(BookDTO bookDTO, Long id){
        for (Category cat: bookDTO.getCategories()) {
            this.categoryRepository.save(cat);
        }
        Book bookSaved = bookRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));

        bookSaved.setAuthor(bookDTO.getAuthor());
        bookSaved.setCategories(bookDTO.getCategories());
        bookSaved.setIsbn(bookDTO.getIsbn());
        bookSaved.setQuantityAvailable(bookDTO.getQuantityAvailable());
        bookSaved.setSellPrice(bookDTO.getSellPrice());
        bookSaved.setResume(bookDTO.getResume());
        bookSaved.setName(bookDTO.getName());
        bookSaved.setYearOfPublication(bookDTO.getYearOfPublication());

        bookRepository.save(bookSaved);

    }
}
