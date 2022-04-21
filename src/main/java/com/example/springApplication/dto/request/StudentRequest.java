package com.example.springApplication.dto.request;

import lombok.Data;

@Data
public class StudentRequest {

    private String name;
    private String surname;
    private Integer age;
    private String address;
    private String phone;

}
