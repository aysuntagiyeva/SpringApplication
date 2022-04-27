package com.example.springApplication.service;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;

import java.util.List;

public interface StudentServiceModern {

    List<StudentResponse> findAll();

    Long addStudent(StudentRequest studentRequest);

    List<StudentResponse> getStudentsByAddress(String address);

    StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

}
