package com.mkl.book.booktest.repository;

import com.mkl.book.booktest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    //Book save(Book book);
    //List<Book> saveAll(List<Book> books);
}
