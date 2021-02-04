package com.mkl.book.booktest.service;

import com.mkl.book.booktest.domain.Book;
import com.mkl.book.booktest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookDBService {
    private final BookRepository bookRepository;

    @Autowired
    public BookDBService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> FindBooksBypageRequest(Pageable pageable){
        return bookRepository.findAll(pageable).getContent();
    }
}
