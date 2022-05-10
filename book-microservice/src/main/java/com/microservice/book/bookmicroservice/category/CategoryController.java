package com.microservice.book.bookmicroservice.category;

import com.microservice.book.bookmicroservice.category.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private final DeleteCategoryService deleteCategoryService;
    private final FindByIdCategoryService findByIdService;
    private final InsertCategoryService insertCategoryService;
    private final ListAllCategoryService listAllCategoryService;
    private final UpdateCategoryService updateCategoryService;

    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryDTO> listAll(){
        return CategoryDTO.fromAll(listAllCategoryService.listAll());
    }

    @GetMapping("/{id}")
    public CategoryDTO findById(@PathVariable(value="id") Long id){
        return CategoryDTO.from(findByIdService.findById(id));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void insert(@Valid @RequestBody CategoryDTO CategoryDTO) {
        insertCategoryService.insert(Category.to(CategoryDTO));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public void update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long id){
        updateCategoryService.update(categoryDTO, id);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        deleteCategoryService.delete(id);
    }
}
