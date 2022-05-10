package com.microservice.book.bookmicroservice.category.services;

import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCategoryServiceImpl implements DeleteCategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void delete(Long id){
        if(!categoryRepository.existsById(id)){
            throw new ObjectNotFoundException("Object not found");
        }

        categoryRepository.deleteById(id);
    }
}
