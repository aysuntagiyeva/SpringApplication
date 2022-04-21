package com.example.springApplication.repository;

import com.example.springApplication.dto.request.StudentRequest;
import com.example.springApplication.dto.response.StudentResponse;
import com.example.springApplication.entity.Student;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class StudentRepo {

    private final ModelMapper modelMapper;
    public static List<Student> studentDb = new ArrayList<>();
    private static Long virtualId = 1L;

    static {
        studentDb.add(new Student(virtualId,
                "Jala",
                "Nasirli",
                19,
                "Baku",
                "+994706378862",
                UUID.randomUUID().toString()));
    }

    public List<StudentResponse> getStudentList() {
//        List<StudentResponse> responseStudentList = new ArrayList<>();
//        for (Student st : studentDb) {
//            StudentResponse response = StudentResponse.builder()
//                    .name(st.getName())
//                    .surname(st.getSurname())
//                    .age(st.getAge())
//                    .phone(st.getPhone())
//                    .build();
//
//            responseStudentList.add(response);
//        }
//
//        return responseStudentList;
        return studentDb.stream()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .collect(Collectors.toList());
    }

    public StudentResponse getStudentById (Long studentId) {
//        boolean check = false;
//        StudentResponse response = null;
//        for (Student st : studentDb) {
//            if (st.getId() == studentId) {
//                check = true;
//                response = modelMapper.map(st, StudentResponse.class);
////                         = StudentResponse.builder()
////                        .name(st.getName())
////                        .surname(st.getSurname())
////                        .age(st.getAge())
////                        .phone(st.getPhone())
////                        .build();
//                break;
//            }
//        }
//
//        if (!check) {
//            System.out.println("Not found!");
//        }
//
//        return response;

        return studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .map(student -> modelMapper.map(student, StudentResponse.class))
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }

    public Long addStudent (StudentRequest studentRequest) {
        Student student = modelMapper.map(studentRequest, Student.class);
        virtualId++;
        student.setId(virtualId);
        student.setPrivateColumn(UUID.randomUUID().toString());
        studentDb.add(student);
        return virtualId;
    }

    public StudentResponse updateStudent (StudentRequest studentRequest, Long studentId) {
        //student in the database
        Student studentDbModel = studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found!"));

        //Making student from service by request.
        Student newStudent = modelMapper.map(studentRequest, Student.class);
        newStudent.setId(studentDbModel.getId());
        newStudent.setPrivateColumn(studentDbModel.getPrivateColumn());

        //Deleting old student and adding new student, i.e. updating process.
        studentDb.remove(studentDbModel);
        studentDb.add(newStudent);

        return modelMapper.map(newStudent, StudentResponse.class);
    }

    public StudentResponse deleteStudent(Long studentId) {
        Student studentRemove = studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found!"));
        studentDb.remove(studentRemove);

        return modelMapper.map(studentRemove, StudentResponse.class);
    }

}
