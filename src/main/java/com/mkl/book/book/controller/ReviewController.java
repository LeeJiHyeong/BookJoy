package com.mkl.book.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @GetMapping("/list")
    public String ReviewList(){
        return "ReviewListTest";
    }

    @GetMapping("/detail")
    public String ReviewDetail(@RequestParam("id") String id){
        return "ReviewDetailTest"; //해당 책id의 페이지가 나와야함
    }

    @PostMapping("/detail")
    public void ReviewInput(String review){


    }
}
