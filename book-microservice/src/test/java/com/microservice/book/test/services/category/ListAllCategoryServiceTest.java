package com.microservice.book.test.services.category;

import com.microservice.book.bookmicroservice.category.Category;
import com.microservice.book.bookmicroservice.category.CategoryRepository;
import com.microservice.book.bookmicroservice.category.services.ListAllCategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.microservice.book.test.builder.CategoryBuilder.createCategory;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ListAllCategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private ListAllCategoryServiceImpl listAllCategoryService;

    @BeforeEach
    public void setup() throws  Exception{
        MockitoAnnotations.openMocks(this);
        this.listAllCategoryService = new ListAllCategoryServiceImpl(categoryRepository);}

    @Test
    void whenFindAllThenReturnAnListOfCategories() {

        when(categoryRepository.findAll()).thenReturn(Stream.of(createCategory().build()).collect(Collectors.toList()));

        List<Category> response = listAllCategoryService.listAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(Category.class, response.get(0).getClass());

        assertEquals(2L, response.get(0).getId());
        Assertions.assertEquals("Mangá", response.get(0).getName());
    }
}
