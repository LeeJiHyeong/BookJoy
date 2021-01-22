package com.mkl.book.user;

import com.mkl.book.user.domain.User;
import com.mkl.book.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserRepository userRepository;


    @Test
    public void 회원가입테스트() {

        User user = new User();
        user.setNickName("딕킴4");
        user.setUserEmail("aaaaa2a2@naaaaaa.com");
        user.setUserPassword("123123");

        this.userRepository.save(user);
    }
}
