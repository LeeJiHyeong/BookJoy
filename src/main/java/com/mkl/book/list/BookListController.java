package com.mkl.book.list;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookListController {

    @RequestMapping("list")
    public String goBookList() {
        return "booklist";
    }

    @RequestMapping("list/detail")
    public String goBookDetail() {
        return "bookdetail";
    }

}
