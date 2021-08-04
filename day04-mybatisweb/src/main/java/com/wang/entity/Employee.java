package com.wang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    private Integer id;
    private String name;
    private String email;
    private Integer gender;
    private Integer departmentId;
    private Date birth;
}
