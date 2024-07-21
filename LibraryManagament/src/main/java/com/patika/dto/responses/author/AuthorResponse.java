package com.patika.dto.responses.author;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponse {
    private  int id;

    private String authorName;
    private  int authorBirthdate;
    private String authorCountry;
}
