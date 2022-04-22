package com.example.springApplication.service.impl;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.repository.StudentRepo;
import com.example.springApplication.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component(value = "studentService") //Class-level annotation for creating Bean.
@RequiredArgsConstructor //Use to create constructor of Final keywords. DI-2
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo repo;

    @Override
    public List<StudentResponse> getStudentList() {
        return repo.getStudentList();
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        return repo.getStudentById(id);
    }

    @Override
    public Long addStudent(StudentRequest studentRequest) {
        return repo.addStudent(studentRequest);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, Long studentId) {
        //System.out.println("Update method") - it means Log
        return repo.updateStudent(studentRequest, studentId);
    }

    @Override
    public StudentResponse deleteStudent(Long studentId) {
        return repo.deleteStudent(studentId);
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
