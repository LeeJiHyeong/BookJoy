package com.mkl.book.booktest.service;

import com.mkl.book.booktest.DTO.BooksResponseDto;
import com.mkl.book.booktest.DTO.Item;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private  final String OpenBookUrl_getKoreaBooks = "http://book.interpark.com/api/bestSeller.api?key=35D9043B16E662BA1268DC72281952F5AB30EDEF0FEAE58F91F21502049E04A1&categoryId=100&output=json";
    private  final String OpenBookUrl_getForeignBooks = "http://book.interpark.com/api/bestSeller.api?key=35D9043B16E662BA1268DC72281952F5AB30EDEF0FEAE58F91F21502049E04A1&categoryId=200&output=json";

    public BooksResponseDto requestBook(){

        restTemplate.getInterceptors().add((request, body, execution) -> {
            ClientHttpResponse response = execution.execute(request,body);
            response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return response;
        });
        final HttpHeaders headers = new HttpHeaders();
        final HttpEntity<?> entity = new HttpEntity<>(headers);

        BooksResponseDto KoreaBookBody = restTemplate.exchange(OpenBookUrl_getKoreaBooks, HttpMethod.GET, entity, BooksResponseDto.class).getBody();
        BooksResponseDto ForeignBookBody = restTemplate.exchange(OpenBookUrl_getForeignBooks, HttpMethod.GET, entity, BooksResponseDto.class).getBody();

        List<Item> items = Stream.concat(KoreaBookBody.getItem().stream(), ForeignBookBody.getItem().stream())
                .collect(Collectors.toList());

        BooksResponseDto body = new BooksResponseDto();
        body.setItem(items);

        List<Book> koreaBooks = KoreaBookBody.ListDtoToListEntity(KoreaBookBody.getItem());
        List<Book> foreignBooks = ForeignBookBody.ListDtoToListEntity(ForeignBookBody.getItem());
        List<Book> books = Stream.concat(koreaBooks.stream(), foreignBooks.stream())
                .collect(Collectors.toList());

        bookSaveAll(books);
        return body;
    }

    public void bookSave(List<Book> books){
        bookRepository.saveAll(books);
    }



    public boolean booleanvalidateDuplicateBook(Book book){
        boolean present = bookRepository.findByIsbn(book.getIsbn()).isPresent();
        return present;
    }

    public void bookSaveAll(List<Book> books){
        books.stream().forEach(book -> {
            if(!booleanvalidateDuplicateBook(book)){
                System.out.println(book);
                bookRepository.save(book);
            }
            else{
                System.out.println("이미 있는 책입니다." + book.getIsbn());
            }
        });
    }

}
