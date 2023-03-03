package com.myplace.myplace.serverTest;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestResponseDto test() {
        return new TestResponseDto("hello");
    }
}
