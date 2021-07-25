package com.wang.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;

@Component
@ConfigurationProperties(prefix = "dog")
@Validated
public class Dog {
    @Length(min = 5, max = 10)
    //@Email(message = "用户名格式错误")
    private String lastName;
    private Integer age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
