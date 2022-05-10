package com.microservice.book.test.services.category;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryDTO;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.bookmicroservice.category.services.UpdateCategoryServiceImpl;
import com.microservice.book.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.microservice.book.test.builder.CategoryBuilder.createCategory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UpdateCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private UpdateCategoryServiceImpl updateCategoryService;

    @Autowired
    private Optional<Category> optionalCategory;

    @BeforeEach
    public void setup() throws  Exception{
        MockitoAnnotations.openMocks(this);
        this.updateCategoryService = new UpdateCategoryServiceImpl(categoryRepository);
        startCategory();
    }

    @Test
    void whenUpdateThenReturnSuccess() {

        Category putCategoryRequest = createCategory()
                .id(2L)
                .name("Mangá")
                .build();

        when(categoryRepository.findById(anyLong())).thenReturn(optionalCategory);

        updateCategoryService.update(CategoryDTO.from(putCategoryRequest), 2L);

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        Category response = categoryArgumentCaptor.getValue();

        assertNotNull(response);
        assertEquals(Category.class, response.getClass());
        Assertions.assertEquals(2L, response.getId());
        Assertions.assertEquals("Mangá", response.getName());
    }

    public void startCategory(){

        Category category = new Category(2L, "Mangá");

        CategoryDTO categoryDTO = new CategoryDTO(2L, "Mangá");

        optionalCategory = Optional.of(new Category(2L, "Mangá"));
    }
}
