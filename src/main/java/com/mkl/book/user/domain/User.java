package com.mkl.book.user.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_email", unique = true)
    @NotNull
    private String userEmail;

    @Column(name = "user_password")
    @NotNull
    private String userPassword;

    @Column(name = "user_nickname", unique = true)
    @NotNull
    private String nickName;

//    @Column(name = "create_date")
//    private Calendar createDate;

}
