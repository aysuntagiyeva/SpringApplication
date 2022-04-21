package com.example.springApplication.service;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

//    String getStudentInfo();

    List<StudentResponse> getStudentList();

    StudentResponse getStudentById(Long id);

    Long addStudent(StudentRequest studentRequest);

    StudentResponse updateStudent(StudentRequest studentRequest, Long studentId);

    StudentResponse deleteStudent(Long studentId);

}
