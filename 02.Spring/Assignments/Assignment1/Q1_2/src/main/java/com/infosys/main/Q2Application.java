package com.infosys.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.infosys.beans.LibraryService;
import com.infosys.config.AppConfig;

@SpringBootApplication
public class Q2Application {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		LibraryService service= context.getBean(LibraryService.class);
		
		service.addBook("Clean Code", "Uncle Bob");
        service.addBook("Effective Java", "Joshua Bloch");
        service.showBooks();
		context.close();
	}

}
