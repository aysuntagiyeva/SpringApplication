package com.example.springApplication.controller;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.service.StudentService;
import com.example.springApplication.service.StudentServiceModern;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentServiceModern serviceModern;
//    private final StudentRepository repository;

    //this part for link
    @GetMapping
    public List<StudentResponse> getStudentList() {
        //return studentService.getStudentList();
        return serviceModern.findAll();
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable("id") @Min(value = 0, message = "ID which entered must be" +
            "equal or greater than 0!") Long id) { //@Min is using to check inline.
        //return studentService.getStudentById(studentId);
        return serviceModern.getStudentById(id);
    }

//    @GetMapping("/{address}")
//    public List<StudentResponse> getStudentsByAddress(@PathVariable @Size(min = 0) String address) {
//        return serviceModern.getStudentsByAddress(address);
//    }

    @PostMapping
    public Long addStudent(@RequestBody @Valid StudentRequest studentRequest) { //@Valid is using to check inside of Object.
        //return studentService.addStudent(studentRequest);
        //If we accept an object, we must use @RequestBody for its accepting like an Object.
        //Vice-versa, considering null.
        return serviceModern.addStudent(studentRequest);
    }

//    @GetMapping("/test")
//    public Student getById(@RequestParam Long studentId) {
//        return repository.getById(studentId);
//    }

    @PutMapping //There is not any String, so, it means QueryParam.
    public StudentResponse updateStudent(@RequestBody @Valid StudentRequest studentRequest,
                                         @RequestParam("id") @Min(value = 0) Long studentId) {
        //return studentService.updateStudent(studentRequest, studentId);
        return serviceModern.updateStudent(studentRequest, studentId);
    }

    @DeleteMapping("/{studentId}")
    public StudentResponse deleteStudent(@PathVariable @Min(value = 0) Long studentId) {
        //return studentService.deleteStudent(studentId);
        return serviceModern.deleteStudent(studentId);
    }

}
