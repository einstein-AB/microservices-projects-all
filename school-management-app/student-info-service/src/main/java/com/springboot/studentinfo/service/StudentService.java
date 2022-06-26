package com.springboot.studentinfo.service;

import com.springboot.studentinfo.dao.StudentDao;
import com.springboot.studentinfo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public Flux<Student> getAllStudents(long staffId) {
        return studentDao.findAll(staffId);
    }
}
