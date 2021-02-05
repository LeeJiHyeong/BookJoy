package com.mkl.book.book.service;

import com.mkl.book.book.domain.Book;
import com.mkl.book.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
