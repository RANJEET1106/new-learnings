package com.infosys.main;

import com.infosys.beans.Developer;
import com.infosys.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Developer developer = context.getBean(Developer.class);
        developer.setTeamName("XYZ");
        developer.setDeveloperName("RANJEET");

        System.out.println("Dev Name : " + developer.getDeveloperName());
        System.out.println("Team Name : " + developer.getTeamName());
        System.out.println("Project name "+developer.getProject().getProjectName());
    }
}
