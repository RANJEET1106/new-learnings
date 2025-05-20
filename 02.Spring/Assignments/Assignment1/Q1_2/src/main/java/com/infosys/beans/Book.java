package com.infosys.beans;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String bookName;
    private String bookAuthor;

    public Book(){

    }

    public Book(String bookName,String bookAuthor){
        this.bookName=bookName;
        this.bookAuthor=bookAuthor;
    }
    public String getBookName(){
        return this.bookName;
    }
    public void setBookName(String bookName){
        this.bookName=bookName;
    }

    public String getAuthor(){
        return this.bookAuthor;
    }
    public void setBookAuthor(String bookAuthor){
        this.bookAuthor=bookAuthor;
    }


}
