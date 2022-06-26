package com.springboot.studentinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private long studentId;
    private String studentName;
    private long staffId;
    private String classTeacherName;
}
