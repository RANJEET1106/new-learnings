package com.infosys.EmployeeManage.exception;


public class EmployeeException extends RuntimeException {
  public EmployeeException() {}
  public EmployeeException(long id){
    super(id+" Can't find employee");
  }

}
