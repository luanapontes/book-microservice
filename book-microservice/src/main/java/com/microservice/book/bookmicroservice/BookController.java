package com.microservice.book.bookmicroservice;

import com.microservice.book.bookmicroservice.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final DeleteBookService deleteBookService;
    private final FindAllBookByCategoryService findAllBookByCategoryService;
    private final FindByIdBookService findByIdService;
    private final InsertBookService insertBookService;
    private final ListAllBookService listAllService;
    private final UpdateBookService updateBookService;
    private final GetSpecificIdBookService getSpecificIdBookService;

    @GetMapping
    public List<BookDTO> listAll(){
        return BookDTO.fromAll(listAllService.listAll());
    }

    @GetMapping(value = "{id}")
    public BookDTO findById(@PathVariable(value="id") Long id){
        return BookDTO.from(findByIdService.findById(id));
    }

    @GetMapping(value = "/id/{specificID}")
    public BookDTO findSpecificID(@PathVariable String specificID) {
        return BookDTO.from(getSpecificIdBookService.findBySpecificID(specificID));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void insert(@RequestBody @Valid BookDTO bookDTO) {
        insertBookService.insert(Book.to(bookDTO));
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public void update(@Valid @RequestBody BookDTO bookDTO, @PathVariable Long id){
        updateBookService.update(bookDTO, id);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        deleteBookService.delete(id);
    }

    @GetMapping(path = "/categoryname/{name}")
    public List<BookDTO> findAllBooksByCategoryName(@PathVariable String categoryName){
        return BookDTO.fromAll(findAllBookByCategoryService.findAllBookByCategoryName(categoryName));
    }
}
