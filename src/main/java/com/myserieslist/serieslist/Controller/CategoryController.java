package com.myserieslist.serieslist.Controller;

import java.util.List;

import com.myserieslist.serieslist.Entity.Category;
import com.myserieslist.serieslist.Service.CategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    @DeleteMapping("/{categoryId}") 
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping({"/{categoryId}/serie/{serieId}", "/{categoryId}"})
    public Category modifyCategory(@PathVariable Long categoryId, @RequestBody(required = false) Category newCategory, 
                                    @PathVariable(required = false) Long serieId) throws Exception {
        if (serieId != null)  {
            return categoryService.updateCategory(categoryId, serieId);
        } else {
            return categoryService.updateCategory(categoryId, newCategory);
        }
    }

    @DeleteMapping("{categoryId}/serie/{serieId}")
    public void deleteSerieFromCategorie(@PathVariable Long categoryId, @PathVariable Long serieId) {
        categoryService.removeSerie(categoryId, serieId);
    }


}
