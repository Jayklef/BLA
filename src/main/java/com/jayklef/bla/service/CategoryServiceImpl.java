package com.jayklef.bla.service;

import com.jayklef.bla.exception.CategoryNotFoundException;
import com.jayklef.bla.model.Book;
import com.jayklef.bla.model.Category;
import com.jayklef.bla.repository.BookRepository;
import com.jayklef.bla.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category editCategory(Long categoryId, Category category) {

        Category categoryInDb = categoryRepository.findById(categoryId).get();

        if (Objects.nonNull(category.getName())&&
        !"".equalsIgnoreCase(category.getName())){
            category.setName(category.getName());
        }
        return categoryRepository.save(categoryInDb);
    }

    @Override
    public void deleteBookByCategory(Long categoryId) {


        Category category = categoryRepository.findById(categoryId)

                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Set<Book> books = category.getBooks();
        bookRepository.deleteAll(books);

        categoryRepository.deleteById(categoryId);
    }
}
