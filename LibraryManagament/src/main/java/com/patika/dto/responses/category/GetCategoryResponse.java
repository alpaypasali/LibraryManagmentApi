package com.patika.dto.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryResponse {

    private int id;
    private String categoryName;
    private   String categoryDescription;
}