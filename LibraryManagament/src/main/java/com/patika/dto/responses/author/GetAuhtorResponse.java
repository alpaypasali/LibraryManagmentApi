package com.patika.dto.responses.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAuhtorResponse {
    private  int id;
    private String authorName;
    private  int authorBirthdate;
    private String authorCountry;
}
