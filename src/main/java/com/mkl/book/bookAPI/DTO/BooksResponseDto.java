package com.mkl.book.bookAPI.DTO;

import com.mkl.book.bookAPI.domain.Book;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class BooksResponseDto {
    private List<Item> item;

    public List<Book> ListDtoToListEntity(List<Item> item){
        return item.stream()
                .map(Item::toEntity)
                .collect(Collectors.toList());
    }

}
