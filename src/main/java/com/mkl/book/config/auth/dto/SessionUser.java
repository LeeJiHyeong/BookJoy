package com.mkl.book.config.auth.dto;

import com.mkl.book.user.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getNickName();
        this.email = user.getUserEmail();
        this.picture = user.getUserPicture();
    }
}