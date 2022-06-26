package com.springboot.staffinfo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.staffinfo.dto.Staff;
import com.springboot.staffinfo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping ("/staff")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping(value = "/all/{schoolId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @HystrixCommand
    public Flux<Staff> getAllStaff(@PathVariable long schoolId) {
        return staffService.getAllStaff(schoolId);
    }
}
