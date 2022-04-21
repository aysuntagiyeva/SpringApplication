package com.example.springApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private String phone;
    private String privateColumn;

}
