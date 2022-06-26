package com.springboot.staffinfo.dao;

import com.springboot.staffinfo.data.StaffDummyDataService;
import com.springboot.staffinfo.dto.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class StaffDao {

    @Autowired
    private StaffDummyDataService staffDummyDataService;

    public Flux<Staff> findAll(long schoolId) {
        return staffDummyDataService.getStaffDummyData(schoolId);
    }

}
