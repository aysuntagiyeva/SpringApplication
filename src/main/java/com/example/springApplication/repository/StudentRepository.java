package com.example.springApplication.repository;

import com.example.springApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Actually, it was created with using JpaRepository. (but use)
public interface StudentRepository extends JpaRepository<Student, Long> {
    //<Student, Long> -> for defining methods automatically in the background.

//    List<Student> findAllByAddress(String address);

//    @Query(value = "select * from spring.student where id = ?1", nativeQuery = true) //Native Query
//    Student getById(Long id);

//    @Query(value = "select s from Student s where s.id =: studentId") //JPQL
//    Student getById(@Param("studentId") Long id);

}
