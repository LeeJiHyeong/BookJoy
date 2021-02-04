package com.mkl.book.book.controller;

import com.mkl.book.book.service.BookApiClient;
import com.mkl.book.book.DTO.BooksResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    private final BookApiClient bookApiClient;

    @Autowired
    public BookController(BookApiClient bookApiClient) {
        this.bookApiClient = bookApiClient;
    }

    @GetMapping("/book")
    public BooksResponseDto goBookPage(){
        return bookApiClient.requestBook();
    }

}
