package com.patika.dto.requests.author;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAuthorRequest {
    @NotBlank(message = "Please provide a author name")
    @Size(min = 3, message = "Author name must be at least 3 characters long")
    @NotEmpty(message = "Author name cannot empty")
    private String authorName;

    private  int authorBirthdate;

    @NotBlank(message = "Please provide a author country")
    private String authorCountry;
}
