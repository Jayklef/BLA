package com.jayklef.bla.controller;

import com.jayklef.bla.model.Book;
import com.jayklef.bla.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
    Book newbook = bookService.saveBook(book);
    return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/all-books")
    public ResponseEntity <List<Book>> getAllBooks(){
    List<Book> bookList = bookService.findAllBooks();
    return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PutMapping("/update-book/{bookId}")
    public ResponseEntity<Book> editBook(@PathVariable("bookId") Long bookId,
                                         @RequestBody Book book){
    Book bookToEdit = bookService.editBook(bookId, book);
    return new ResponseEntity<>(bookToEdit, HttpStatus.OK);
    }

    @PostMapping("/book/category/{bookId}")
    public String addBookToCategory(@PathVariable("bookId") Long bookId,
                                    @RequestParam Long categoryId){
        bookService.addBookToCategory(bookId, categoryId);
         return "book saved successfully";
    }

    @DeleteMapping("/delete/{bookId}")
    private String deleteBook(@PathVariable("bookId") Long bookId){
        bookService.deleteBookById(bookId);
        return "Book deleted Successfully";
    }
}
