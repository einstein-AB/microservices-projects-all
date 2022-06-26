package com.springboot.staffinfo.data;

import com.github.javafaker.Faker;
import com.springboot.staffinfo.dto.Staff;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Service
public class StaffDummyDataService {

    public Flux<Staff> getStaffDummyData(long schoolId) {
        Faker fakerTeacher = new Faker();

        final long[] dummyStaffId = new long[1];
        Flux<Staff> staffFlux = Flux.range(1, 10)
                //.delayElements(Duration.ofSeconds(1))
                .doOnNext(index -> {
                    dummyStaffId[0] = index;
                    System.out.println("processing staff stream count: " + index + " for schoolId: " + schoolId);
                }).map(id ->
                        new Staff(id, fakerTeacher.name().fullName(), id + RandomStringUtils.randomAlphabetic(1)));

        return staffFlux;
    }
}
