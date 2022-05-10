package com.microservice.book.test.services.category;

import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.bookmicroservice.category.services.DeleteCategoryServiceImpl;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class DeleteCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private DeleteCategoryServiceImpl deleteCategoryService;

    @BeforeEach
    public void setup() throws  Exception{
        MockitoAnnotations.openMocks(this);
        this.deleteCategoryService = new DeleteCategoryServiceImpl(categoryRepository);}

    @Test
    void deleteWithSuccess() {

        when(categoryRepository.existsById(anyLong())).thenReturn(true);
        deleteCategoryService.delete(2L);
        verify(categoryRepository).existsById(anyLong());
        verify(categoryRepository).deleteById(anyLong());
    }

    @Test
    void deleteWithObjectNotFoundException(){

        when(categoryRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Object not found"));
        try{
            deleteCategoryService.delete(2L);
        } catch (Exception exception){
            assertEquals(ObjectNotFoundException.class, exception.getClass());
            assertEquals("Object not found", exception.getMessage());
        }
    }
}
