package com.infosys.adminrest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminResponse {
    private HttpStatusCode httpStatus;
    private String httpMessage;
}
