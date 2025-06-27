package com.infosys.postgrerest.Exception;

import com.infosys.postgrerest.model.CourseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CourseResponse> exceptionHandler(CourseException courseException) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusCode(500);
        courseResponse.setStatusMessage("Course Not Found");
        courseResponse.setResponseDate(LocalDate.now());
        return new ResponseEntity<CourseResponse>(courseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setStatusMessage(ex.getMessage());
        return new ResponseEntity<>(courseResponse, HttpStatus.BAD_REQUEST);
    }
}
