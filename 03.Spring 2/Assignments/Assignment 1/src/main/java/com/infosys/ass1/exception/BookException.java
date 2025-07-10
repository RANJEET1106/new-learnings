package com.infosys.ass1.exception;

public class BookException extends RuntimeException {
    public BookException(int id){
        super("Book with id "+id+" not found");
    }
}
