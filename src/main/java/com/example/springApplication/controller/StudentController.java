package com.example.springApplication.controller;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    //this part for link
    @GetMapping
    public List<StudentResponse> getStudentList() {
        return studentService.getStudentList();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping
    public Long addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
        //If we accept an object, we must use @RequestBody for its accepting like an Object.
        //Vice-versa, considering null.
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
