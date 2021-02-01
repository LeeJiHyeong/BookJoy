package com.mkl.book.booktest.service;

import com.mkl.book.booktest.DTO.BooksResponseDto;
import com.mkl.book.booktest.domain.Book;
import com.mkl.book.booktest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookApiClient {

    private final RestTemplate restTemplate;
    private final BookRepository bookRepository;

    @Autowired
    public BookApiClient(RestTemplate restTemplate, BookRepository bookRepository) {
        this.restTemplate = restTemplate;
        this.bookRepository = bookRepository;
    }

    private  final String OpenBookUrl_getBooks = "http://book.interpark.com/api/bestSeller.api?key=35D9043B16E662BA1268DC72281952F5AB30EDEF0FEAE58F91F21502049E04A1&categoryId=100&output=json";

    public BooksResponseDto requestBook(){

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        final HttpHeaders headers = new HttpHeaders();
        final HttpEntity<?> entity = new HttpEntity<>(headers);

        BooksResponseDto body = restTemplate.exchange(OpenBookUrl_getBooks, HttpMethod.GET, entity, BooksResponseDto.class).getBody();
        List<Book> books = body.ListDtoToListEntity(body.getItem());
        bookSave(books);
        return body;
    }

    public void bookSave(List<Book> books){
        bookRepository.saveAll(books);
    }


}
