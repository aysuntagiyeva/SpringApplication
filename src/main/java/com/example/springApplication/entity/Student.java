package com.example.springApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Component
@Entity //relational classes with database (named POJO or Entity Classes)
@Table(name = "student")
public class Student {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Identity -> means sequence for MySQL.
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private String phone;

    @OneToOne //for connecting
    private Series series;

    @ManyToOne
    private Group group;

}
