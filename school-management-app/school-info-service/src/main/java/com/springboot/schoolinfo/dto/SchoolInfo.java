package com.springboot.schoolinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.core.publisher.Flux;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolInfo {
    private String schoolId;
    private Flux<Student> students;
    private Flux<Staff> staff;
}
