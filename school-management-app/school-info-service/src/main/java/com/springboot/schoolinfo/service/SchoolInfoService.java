package com.springboot.schoolinfo.service;

import com.springboot.schoolinfo.dto.SchoolInfo;
import com.springboot.schoolinfo.dto.Staff;
import com.springboot.schoolinfo.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
@RefreshScope
public class SchoolInfoService {

    @Autowired
    @Lazy
    private WebClient.Builder webClientBuilder;

    @Value("${microservices.staff-info-service.endpoints.endpoint.uri}")
    private String STAFF_INFO_ENDPOINT;

    @Value("${microservices.student-info-service.endpoints.endpoint.uri}")
    private String STUDENT_INFO_ENDPOINT;

    public Flux<Staff> getStaffInfo(long schoolId) {
        return webClientBuilder.build()
                .get()
                .uri(STAFF_INFO_ENDPOINT + schoolId)
                .retrieve()
                .bodyToFlux(Staff.class);
    }

    public Flux<Student> getStudentsInfo(long staffId) {
        return webClientBuilder.build()
                .get()
                .uri(STUDENT_INFO_ENDPOINT + staffId)
                .retrieve()
                .bodyToFlux(Student.class);

    }

    public Flux<SchoolInfo> getSchoolInfo(String schoolId, Flux<Student> studentsInfo, Flux<Staff> staffInfo) {
        /*Flux.zip(studentsInfo, staffInfo)
                .flatMap(sFlux-> sFlux.getT1())*/
        return null;
    }
}
