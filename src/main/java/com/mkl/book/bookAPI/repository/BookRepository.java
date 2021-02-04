package com.mkl.book.bookAPI.repository;

import com.mkl.book.bookAPI.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String name);
}
