package com.microservice.book.bookmicroservice.services;

import com.microservice.book.bookmicroservice.BookRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteBookServiceImpl implements DeleteBookService{

    private final BookRepository bookRepository;

    @Override
    public void delete(Long id){
        if(!bookRepository.existsById(id)){
            throw new ObjectNotFoundException("Object not found");
        }

        bookRepository.deleteById(id);
    }
}
