package com.springboot.studentinfo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.studentinfo.dto.Student;
import com.springboot.studentinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping ("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping (value = "/all/{staffId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @HystrixCommand
    public Flux<Student> getAllStudents(@PathVariable long staffId) {
        return studentService.getAllStudents(staffId);
    }
}
