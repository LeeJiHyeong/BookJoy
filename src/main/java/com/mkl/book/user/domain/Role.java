package com.mkl.book.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    GUEST("ROLE_GUSET", "손님"),
    USER("ROLE_USER", "유저"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}
