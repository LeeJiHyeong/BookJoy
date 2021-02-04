package com.mkl.book.book.controller;

import com.mkl.book.book.domain.Book;
import com.mkl.book.book.service.BookDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@RequestMapping("/book")
@Controller
public class BookListsController {

    private final BookDBService bookDBService;

    @Autowired
    public BookListsController(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }


    @GetMapping("/list")
    public String GoBookList(Pageable pageable){
        List<Book> books = bookDBService.FindBooksBypageRequest(pageable);
        return "booklist";
    }

    @RequestMapping("/list/detail")
    public String GoBookDetail() {
        return "bookdetail";
    }
}
