package com.patika.dto.requests.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {

    @NotNull(message = "Category ID must not be null")
    private Integer id;
    @NotBlank(message = "Please provide a category name")
    @Size(min = 3, message = "Category name must be at least 3 characters long")
    @NotEmpty(message = "Category name cannot empty")
    private String categoryName;

    private   String categoryDescription;
}
