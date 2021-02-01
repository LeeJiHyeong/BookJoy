package com.mkl.book.booktest.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId; //책 id?

    private String isbn; //책 고유번호

    private String title; //책 제목

    private String author; //책 저자

    private String description; //책 설명

    private String pubDate; //출간일

    @Column(name = "cover_small_url")
    private String coverSmallUrl; //표지 작은사진

    @Column(name = "cover_large_url")
    private String coverLargeUrl; //표지

    @Column(name = "category_name")
    private String categoryName; //카테고리

    @Column(name = "category_id")
    private String categoryId; //카테고리 세부

    @Column(name="ranking")
    private int rank; //책 랭킹
}
