package com.example.springApplication.service.impl;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.entity.Student;
import com.example.springApplication.exception.StudentNotFoundException;
import com.example.springApplication.repository.StudentRepo;
import com.example.springApplication.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Component(value = "studentService") //Class-level annotation for creating Bean.
@RequiredArgsConstructor //Use to create constructor of Final keywords. DI-2
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;
    private final ModelMapper modelMapper;

    @Override
    public List<StudentResponse> getStudentList() {
        return repo.getStudentList().stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        boolean checkStudent = repo.checkStudent(id);
        if (checkStudent) {
            return modelMapper.map(repo.getStudentById(id), StudentResponse.class);
        } else {
            throw new StudentNotFoundException("Not found!");
        }
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        return repo.addStudent(modelMapper.map(studentRequest, Student.class));
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        //System.out.println("Update method") - it means Log
        boolean checkStudent = repo.checkStudent(studentId);
        if (checkStudent) {
            Student student = repo.updateStudent(modelMapper.map(studentRequest, Student.class), studentId);
            return modelMapper.map(student, StudentResponse.class);
        } else {
            throw new StudentNotFoundException("Not found!");
        }
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        boolean checkStudent = repo.checkStudent(studentId);
        if (checkStudent) {
            return modelMapper.map(repo.deleteStudent(studentId), StudentResponse.class);
        } else {
            throw new StudentNotFoundException("Not found!");
        }
    }

    // @Autowired Use to set to student from Student object inside Container. DI-1
//    private Student student;
//
//    @Autowired
//    ApplicationContext applicationContext;
//
//    @Override
//    public String getStudentInfo() {
        //student.setName("Farida");
        //student.setSurname("Mammadli");
//        student = (Student) applicationContext.getBean("student");
//
//        return student.getName().concat(" ").concat(student.getSurname());
//    }

}
