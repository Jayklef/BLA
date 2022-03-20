package com.jayklef.bla.service;

import com.jayklef.bla.model.Book;

import java.util.List;

public interface BookService {
    Book saveBook(Book book);

    List<Book> findAllBooks();

    Book editBook(Long bookId, Book book);

    void addBookToCategory(Long bookId, Long categoryId);

    void deleteBookById(Long bookId);
}
