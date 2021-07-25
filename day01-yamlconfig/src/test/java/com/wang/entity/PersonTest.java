package com.wang.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PersonTest {
    @Autowired
    private Person person;

    @Test
    void personInfoTest() {
        System.out.println(person);
    }
}
