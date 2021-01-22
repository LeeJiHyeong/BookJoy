package com.mkl.book.user.DTO;

import com.mkl.book.user.domain.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String userEmail;
    private String userPassword;
    private String nickName;
    private String createDate;
}
