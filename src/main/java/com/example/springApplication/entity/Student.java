package com.example.springApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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

    @OneToOne(cascade = CascadeType.ALL) //for connecting
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    private Series series;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

}
