package com.sparta.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto { //클라이언트에서의 입력값
    private String username;
    private String password;
    private String title;
    private String contents;
}
