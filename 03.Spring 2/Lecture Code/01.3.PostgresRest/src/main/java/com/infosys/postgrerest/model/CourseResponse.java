package com.infosys.postgrerest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseResponse {
    private Integer statusCode;
    private String statusMessage;
    private LocalDate responseDate;
}
