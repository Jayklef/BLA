package com.jayklef.bla.service;

import com.jayklef.bla.model.Book;
import com.jayklef.bla.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);

    List<Category> findAllCategory();

    Category editCategory(Long categoryId, Category category);

    void deleteBookByCategory(Long categoryId);
}
