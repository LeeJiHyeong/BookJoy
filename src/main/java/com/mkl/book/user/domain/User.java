package com.mkl.book.user.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Calendar;

@Getter
@NoArgsConstructor
@DynamicInsert
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

    @Column(name = "user_nickname")
    @NotNull
    private String nickName;

    @Column(name = "user_picture")
    private String userPicture;

    @Column(name = "create_date")
    private Calendar createDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private Role userRole;

    @Builder
    public User(String nickName, String userEmail, String userPicture, Role role) {
        this.nickName = nickName;
        this.userEmail = userEmail;
        this.userPicture = userPicture;
        this.userRole = role;
    }

    public User update(String nickName, String userPicture) {
        this.nickName = nickName;
        this.userPicture = userPicture;

        return this;
    }

    public String getRoleKey() {
        return this.userRole.getKey();
    }

}
