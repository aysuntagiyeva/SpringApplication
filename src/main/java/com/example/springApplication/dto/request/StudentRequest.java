package com.example.springApplication.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {

    @NotNull //validation
    private String name;

    @NotNull
    private String surname;

    @NotBlank
    private Integer age;

    @NotNull
    private String address;

    @NotNull
    private String phone;

}
