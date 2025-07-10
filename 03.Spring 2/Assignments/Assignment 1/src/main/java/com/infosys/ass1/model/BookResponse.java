package com.infosys.ass1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookResponse {
    private Integer statusCode;
    private String statusMessage;
    private LocalDate responseDate;
}
