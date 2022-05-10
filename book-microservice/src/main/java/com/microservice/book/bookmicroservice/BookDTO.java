package com.microservice.book.bookmicroservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservice.book.bookmicroservice.category.Category;
import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;

    @NotNull
    private String name;

    @Size(max = 500)
    @NotNull
    private String resume;

    @NotNull
    private Integer isbn;

    @Size(min = 1)
    @NotNull
    private String author;

    @NotNull
    private Integer yearOfPublication;

    @Min(0)
    @NotNull
    private Double sellPrice;

    @NotNull
    private Integer quantityAvailable;

    private String specificID;

    @NotNull
    private List<Category> categories;

    public static BookDTO from(Book dto) {
        return BookDTO
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .resume(dto.getResume())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .yearOfPublication(dto.getYearOfPublication())
                .sellPrice(dto.getSellPrice())
                .quantityAvailable(dto.getQuantityAvailable())
                .categories(dto.getCategories())
                .specificID(dto.getSpecificID())
                .build();
    }

    public static List<BookDTO> fromAll(List<Book> books) {
        return books.stream().map(BookDTO::from).collect(Collectors.toList());
    }

    public static Page<BookDTO> fromPage(Page<Book> pages) {
        return pages.map(BookDTO::from);
    }

}
