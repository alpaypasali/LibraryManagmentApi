package com.patika.dto.requests.author;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuhtorRequest {
    private  int id;
    private String authorName;
    private  int authorBirthdate;
    private String authorCountry;
}
