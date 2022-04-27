package com.example.springApplication.controller;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.service.StudentService;
import com.example.springApplication.service.StudentServiceModern;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentServiceModern serviceModern;

    //this part for link
    @GetMapping
    public List<StudentResponse> getStudentList() {
        //return studentService.getStudentList();
        return serviceModern.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("/{address}")
    public List<StudentResponse> getStudentsByAddress(@RequestParam String address) {
        return serviceModern.getStudentsByAddress(address);
    }

    @PostMapping
    public Long addStudent(@RequestBody StudentRequest studentRequest) {
        //return studentService.addStudent(studentRequest);
        //If we accept an object, we must use @RequestBody for its accepting like an Object.
        //Vice-versa, considering null.
        return serviceModern.addStudent(studentRequest);
    }

    @PutMapping //There is not any String, so, it means QueryParam.
    public StudentResponse updateStudent(@RequestBody StudentRequest studentRequest, @RequestParam("id") Long studentId) {
        return studentService.updateStudent(studentRequest, studentId);
    }

    @DeleteMapping("/{id}")
    public StudentResponse deleteStudent(@PathVariable("id") Long studentId) {
        return studentService.deleteStudent(studentId);
    }

}
