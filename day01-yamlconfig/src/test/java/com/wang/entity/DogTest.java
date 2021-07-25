package com.wang.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DogTest {
    @Autowired
    private Dog dog;

    @Test
    void dogInfoTest() {
        System.out.println(dog);
    }
}
