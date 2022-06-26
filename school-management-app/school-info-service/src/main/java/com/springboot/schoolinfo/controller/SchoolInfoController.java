package com.springboot.schoolinfo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.schoolinfo.dto.Staff;
import com.springboot.schoolinfo.dto.Student;
import com.springboot.schoolinfo.service.SchoolInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping ("/school")
public class SchoolInfoController {

    @Autowired
    SchoolInfoService schoolInfoService;

    @GetMapping(value = "/{schoolId}")
    @HystrixCommand
    public Mono<ResponseEntity> getSchoolInfo(@PathVariable long schoolId) {

        //Get all the staff for a school with `schoolId`
        Flux<Staff> staffInfoFlux = schoolInfoService.getStaffInfo(schoolId);

        //Iterate over staffIds to get info about all the students under/assigned to them
        Flux<Student> studentInfoFlux = staffInfoFlux.flatMap(staff -> schoolInfoService.getStudentsInfo(staff.getStaffId()));

        //return studentInfoFlux;
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(studentInfoFlux));

    }

}
