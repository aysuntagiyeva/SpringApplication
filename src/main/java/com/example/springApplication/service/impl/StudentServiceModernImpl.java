package com.example.springApplication.service.impl;

import com.example.springApplication.dto.response.StudentResponse;
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
}
