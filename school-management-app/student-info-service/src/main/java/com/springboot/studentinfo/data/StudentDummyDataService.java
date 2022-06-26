package com.springboot.studentinfo.data;

import com.github.javafaker.Faker;
import com.springboot.studentinfo.dto.Student;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StudentDummyDataService {

    public Flux<Student> getStudentDummyData(long staffId) {
        Faker fakerStudent = new Faker();
        Faker fakerTeacher = new Faker();

        Flux<Student> studentFlux = Flux.range(1, RandomUtils.nextInt(5, 50))
                //.delayElements(Duration.ofSeconds(1))
                .doOnNext(index-> System.out.println("processing student stream count: "+index))
                .map(id -> new Student(
                        RandomUtils.nextInt(1, 50),
                        fakerStudent.name().fullName(),
                        staffId,
                        fakerTeacher.name().fullName()));

        return studentFlux;
    }
}
