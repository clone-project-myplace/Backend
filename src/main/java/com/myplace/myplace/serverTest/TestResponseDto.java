package com.myplace.myplace.serverTest;

import lombok.Getter;

@Getter
public class TestResponseDto {

    private String msg;

    public TestResponseDto(String msg) {
        this.msg = msg;
    }
}
