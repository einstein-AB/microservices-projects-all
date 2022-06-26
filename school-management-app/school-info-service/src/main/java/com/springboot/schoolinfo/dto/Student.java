package com.springboot.schoolinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private long studentId;
    private String studentName;
    private String staffId;
    private String classTeacherName;
}
