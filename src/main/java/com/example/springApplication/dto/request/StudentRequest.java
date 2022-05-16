package com.example.springApplication.dto.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class StudentRequest {

    @NotBlank //validation
    private String name;

    @NotBlank
    private String surname;

    @NotNull
    private Integer age;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotNull //Object
    private SeriesRequest series;

    @NotNull
    private GroupRequest group;

}
