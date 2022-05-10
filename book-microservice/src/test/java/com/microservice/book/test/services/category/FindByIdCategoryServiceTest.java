package com.microservice.book.test.services.category;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryDTO;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.bookmicroservice.category.services.FindByIdCategoryServiceImpl;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class FindByIdCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private FindByIdCategoryServiceImpl findByIdCategoryService;

    @Autowired
    private Optional<Category> optionalCategory;

    @BeforeEach
    public void setup() throws  Exception{
        MockitoAnnotations.openMocks(this);
        this.findByIdCategoryService = new FindByIdCategoryServiceImpl(categoryRepository);
        startCategory();
    }

    @Test
    void whenfindByIdTheReturnAnCategoryInstance() {

        when(categoryRepository.findById(Mockito.anyLong())).thenReturn(optionalCategory);

        Category response = findByIdCategoryService.findById(2L);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(Category.class, response.getClass());
        Assertions.assertEquals(2L, response.getId());
        Assertions.assertEquals("Mangá", response.getName());

    }

    @Test
    void whenFindByIdThenReturnAnObjectNotFoundException(){

        when(categoryRepository.findById(anyLong())).thenThrow(new ObjectNotFoundException("Object not found"));

        try {
            findByIdCategoryService.findById(2L);
        } catch (Exception exception) {
            assertEquals(ObjectNotFoundException.class, exception.getClass());
            assertEquals("Object not found", exception.getMessage());
        }
    }

    public void startCategory(){

        Category category = new Category(2L, "Mangá");

        CategoryDTO categoryDTO = new CategoryDTO(2L, "Mangá");

        optionalCategory = Optional.of(new Category(2L, "Mangá"));
    }
}
