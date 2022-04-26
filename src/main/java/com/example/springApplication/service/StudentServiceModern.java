package com.example.springApplication.service;

import com.example.springApplication.dto.response.StudentResponse;

import java.util.List;

public interface StudentServiceModern {

    List<StudentResponse> findAll();

}
