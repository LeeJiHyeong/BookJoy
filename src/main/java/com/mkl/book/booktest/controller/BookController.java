package com.mkl.book.booktest.controller;

import com.mkl.book.booktest.service.BookApiClient;
import com.mkl.book.booktest.DTO.BooksResponseDto;
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
