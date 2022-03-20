package com.jayklef.bla.service;

import com.jayklef.bla.exception.BookNotFoundException;
import com.jayklef.bla.exception.CategoryNotFoundException;
import com.jayklef.bla.model.Book;
import com.jayklef.bla.model.Category;
import com.jayklef.bla.repository.BookRepository;
import com.jayklef.bla.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book editBook(Long bookId, Book book) {

        Book bookInDb = bookRepository.findById(bookId).get();

        if (Objects.nonNull(book.getTitle()) &&
        !"".equalsIgnoreCase(book.getTitle())){
            bookInDb.setTitle(book.getTitle());
        }

        if (Objects.nonNull(book.getIsbn())&&
        !"".equalsIgnoreCase(book.getIsbn())){
            bookInDb.setIsbn(book.getIsbn());
        }

        if (Objects.nonNull(book.getAuthor())&&
        !"".equalsIgnoreCase(book.getAuthor())){
            bookInDb.setAuthor(book.getAuthor());
        }

        if (Objects.nonNull(book.getCategory())&&
        !"".equalsIgnoreCase(book.getCategory().toString())){
            bookInDb.setCategory(book.getCategory());
        }
        return bookRepository.save(bookInDb);
    }

    @Override
    public void addBookToCategory(Long bookId, Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));

        book.setCategory(category);
        bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }
}
