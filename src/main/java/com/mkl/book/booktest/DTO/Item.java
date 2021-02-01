package com.mkl.book.booktest.DTO;

import com.mkl.book.booktest.domain.Book;
import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long itemId; //책 id?
    private String isbn; //책 고유번호
    private String title; //책 제목
    private String author; //책 저자
    private String description; //책 설명
    private String pubDate; //출간일
    private String coverSmallUrl; //표지 작은사진
    private String coverLargeUrl; //표지
    private String categoryName; //카테고리
    private String categoryId; //카테고리 세부
    private int rank; //책 랭킹

    public Book toEntity() {
        return new Book(itemId, isbn, title, author, description, pubDate, coverSmallUrl, coverLargeUrl, categoryName, categoryId, rank);
    }

}
