package com.infosys.postgrerest.Exception;

public class CourseException extends RuntimeException {
  public CourseException() {
  }
  public CourseException(int id){
    super(id+" Can't find course");
  }
}
