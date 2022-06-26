package com.springboot.staffinfo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    private long staffId;
    private String name;
    private String classId;
}
