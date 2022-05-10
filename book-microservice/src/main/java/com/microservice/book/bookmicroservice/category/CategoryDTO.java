package com.microservice.book.bookmicroservice.category;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "The category name cannot be empty")
    private String name;

    public CategoryDTO(Category obj){
        this.id = obj.getId();
        this.name = obj.getName();
    }

    public static CategoryDTO from(Category dto) {
        return CategoryDTO
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }

    public static List<CategoryDTO> fromAll(List<Category> categories) {
        return categories.stream().map(CategoryDTO::from).collect(Collectors.toList());
    }

    public static Page<CategoryDTO> fromPage(Page<Category> pages) {
        return pages.map(CategoryDTO::from);
    }

}
