package com.mkl.book.booktest.controller;

import com.mkl.book.booktest.domain.Book;
import com.mkl.book.booktest.service.BookDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("/book")
@Controller
public class BookListController {

    private final BookDBService bookDBService;

    @Autowired
    public BookListController(BookDBService bookDBService) {
        this.bookDBService = bookDBService;
    }


    @GetMapping("/list")
    @ResponseBody
    public String GoBookList(Pageable pageable){
        List<Book> books = bookDBService.FindBooksBypageRequest(pageable);
        return "booklist";
    }

    @RequestMapping("/list/detail")
    public String GoBookDetail() {
        return "bookdetail";
    }
}
