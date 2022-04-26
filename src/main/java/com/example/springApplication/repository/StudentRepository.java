package com.example.springApplication.repository;

import com.example.springApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //Actually, it was created with using JpaRepository. (but use)
public interface StudentRepository extends JpaRepository<Student, Long> {
    //<Student, Long> -> for defining methods automatically in the background.

    Optional<Student> findByAddress(String address);

}
