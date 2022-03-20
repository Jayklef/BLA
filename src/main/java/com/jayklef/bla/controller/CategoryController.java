package com.jayklef.bla.controller;

import com.jayklef.bla.model.Book;
import com.jayklef.bla.model.Category;
import com.jayklef.bla.service.BookService;
import com.jayklef.bla.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category newCategory = categoryService.addCategory(category);
    return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/all-categories")
    public ResponseEntity<List<Category>> findAllCategory(){
        List<Category> categoryList = categoryService.findAllCategory();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PutMapping("/edit-category/{categoryId}")
    public ResponseEntity<Category> editCategory(@PathVariable("categoryId") Long categoryId,
                                                 @RequestBody Category category){
        Category categoryToEdit = categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(categoryToEdit, HttpStatus.OK);
    }

    @DeleteMapping("/category/{categoryId}")
    public String deleteCategoryWithBooks(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteBookByCategory(categoryId);
        return "Category removed successfully";
    }
}
