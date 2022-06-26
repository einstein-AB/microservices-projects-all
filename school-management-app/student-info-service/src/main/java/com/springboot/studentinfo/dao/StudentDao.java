package com.springboot.studentinfo.dao;

import com.springboot.studentinfo.data.StudentDummyDataService;
import com.springboot.studentinfo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class StudentDao {

    @Autowired
    StudentDummyDataService studentDummyDataService;

    public Flux<Student> findAll(long staffId) {
        return studentDummyDataService.getStudentDummyData(staffId);
    }
}
