package com.example.springApplication.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

    private Long id;
    private String name;
    private String surname;
    private Integer age;
    private String address;
    private String phone;
    private SeriesResponse series;
    private GroupResponse group;

}
