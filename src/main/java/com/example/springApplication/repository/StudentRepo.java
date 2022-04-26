package com.example.springApplication.repository;

import com.example.springApplication.entity.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class StudentRepo {

    public static List<Student> studentDb = new ArrayList<>();
    private static Long virtualId = 1L;

    static {
        studentDb.add(new Student(virtualId,
                "Jala",
                "Nasirli",
                19,
                "Baku",
                "+994706378862"));
    }

    public List<Student> getStudentList() {
        return studentDb;

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
    }

    public Student getStudentById(Long studentId) {
        return studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst().get();

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
    }

    public Long addStudent(Student student) {
        virtualId++;
        student.setId(virtualId);
        studentDb.add(student);
        return virtualId;
    }

    public Student updateStudent(Student student, Long studentId) {
        //student in the database
        Student studentDbModel = studentDb.stream().filter(studentDb -> studentDb.getId().equals(studentId))
                .findFirst().get();

        //Making student from service by request.
        student.setId(studentDbModel.getId());

        //Deleting old student and adding new student, i.e. updating process.
        studentDb.remove(studentDbModel);
        studentDb.add(student);

        return student;
    }

    public Student deleteStudent(Long studentId) {
        Optional<Student> studentRemove = studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst();
        studentDb.remove(studentRemove.get());

        return studentRemove.get();
    }

    public boolean checkStudent(Long studentId) {

        boolean k = false;
        Optional<Student> studentModel = studentDb.stream().filter(student -> student.getId().equals(studentId))
                .findFirst();
        if (studentModel.isPresent()) {
            k = true;
        }

        return k;

    }

}
