package com.example.springApplication.service.impl;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.entity.Student;
import com.example.springApplication.exception.StudentNotFoundException;
import com.example.springApplication.repository.StudentRepository;
import com.example.springApplication.service.StudentServiceModern;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceModernImpl implements StudentServiceModern {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> findAll() {
        return studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        Student savedStudent = studentRepository.save(modelMapper.map(studentRequest, Student.class));
        return savedStudent.getId();
    }

//    @Override
//    public List<StudentResponse> getStudentsByAddress(String address) {
//        return studentRepository.findAllByAddress(address).stream()
//                .map(student -> modelMapper.map(student, StudentResponse.class))
//                .collect(Collectors.toList());
//    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return studentRepository.findById(id)
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .orElseThrow(() -> new StudentNotFoundException("Not found!"));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Not found!"));
        modelMapper.map(studentRequest, dbStudent);
        studentRepository.save(dbStudent);
        return modelMapper.map(dbStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        Student dbStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Not found!"));
        studentRepository.delete(dbStudent);
        return modelMapper.map(dbStudent, StudentResponse.class);
    }
}
