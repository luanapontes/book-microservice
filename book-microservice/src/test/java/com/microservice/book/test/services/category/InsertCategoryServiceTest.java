package com.microservice.book.test.services.category;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.bookmicroservice.category.services.InsertCategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.microservice.book.test.builder.CategoryBuilder.createCategory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class InsertCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private InsertCategoryServiceImpl insertCategoryService;

    @BeforeEach
    public void setup() throws  Exception{
        MockitoAnnotations.openMocks(this);
        this.insertCategoryService = new InsertCategoryServiceImpl(categoryRepository);}

    @Test
    void whenInsertThenReturnSuccess() {

        Category category = createCategory().build();
        insertCategoryService.insert(category);

        when(categoryRepository.save(Mockito.any())).thenReturn(category);

        ArgumentCaptor<Category> categoryArgumentCaptor = ArgumentCaptor.forClass(Category.class);
        verify(categoryRepository).save(categoryArgumentCaptor.capture());

        Category response = categoryArgumentCaptor.getValue();

        assertNotNull(response);
        assertEquals(Category.class, response.getClass());
        assertEquals(2L, response.getId());
        assertEquals("Mangá", response.getName());
    }
}
