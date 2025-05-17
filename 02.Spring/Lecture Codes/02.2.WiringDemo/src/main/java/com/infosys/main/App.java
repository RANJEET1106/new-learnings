package com.infosys.main;

import com.infosys.beans.Developer;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App
{
    public static void main( String[] args ){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Developer developer = context.getBean(Developer.class);
        System.out.println(("Developer Name "+developer.getDeveloperName()));
        System.out.println("Team Name "+developer.getTeamName());
        System.out.println("Project Name "+developer.getProject().getProjectName());

    }
}
