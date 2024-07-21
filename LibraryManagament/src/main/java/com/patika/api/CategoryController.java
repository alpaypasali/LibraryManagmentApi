package com.patika.api;

import com.patika.business.abstracts.ICategoryService;
import com.patika.core.utilities.results.DataResult;
import com.patika.core.utilities.results.Result;
import com.patika.dto.requests.category.CreateCategoryRequest;
import com.patika.dto.requests.category.UpdateCategoryRequest;
import com.patika.dto.responses.category.CategoryResponse;
import com.patika.dto.responses.category.GetAllCategoryResponse;
import com.patika.dto.responses.category.GetCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private  final ICategoryService categoryService;

    @GetMapping()
    public DataResult<List<GetAllCategoryResponse>> getAll(){
        return this.categoryService.getAll();
    }

    @GetMapping("/{id}")
    public DataResult<GetCategoryResponse> getCategory(@PathVariable("id") int id){
        return categoryService.getCategoryById(id);


    }

    @PostMapping()
    public ResponseEntity<Result> create(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
        Result result = categoryService.create(createCategoryRequest);
        return ResponseEntity.ok(result);
    }

    @PutMapping()
    public DataResult<CategoryResponse> update(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest){
         return categoryService.update(updateCategoryRequest);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        Result result = categoryService.delete(id);
        return ResponseEntity.ok(result);
    }
}
