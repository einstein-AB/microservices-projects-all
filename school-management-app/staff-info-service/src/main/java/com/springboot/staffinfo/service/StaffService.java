package com.springboot.staffinfo.service;

import com.springboot.staffinfo.dao.StaffDao;
import com.springboot.staffinfo.dto.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StaffService {

    @Autowired
    private StaffDao staffDao;

    public Flux<Staff> getAllStaff(long schoolId) {
        return staffDao.findAll(schoolId);
    }


}
