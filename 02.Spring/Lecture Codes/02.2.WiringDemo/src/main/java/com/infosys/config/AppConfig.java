package com.infosys.config;

import com.infosys.beans.Developer;
import com.infosys.beans.Project;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Project project() {
        Project project = new Project();
        project.setProjectName("Finacle");
        return project;
    }

//    @Bean
//    // wiring using method call
//    public Developer developer() {
//        Developer developer = new Developer();
//        developer.setDeveloperName("RANJEET");
//        developer.setTeamName("Architecture");
//        developer.setProject(project());
//        return developer;
//    }

    // wiring using method parameter
    @Bean
    public Developer developer(Project project) {
        Developer developer = new Developer();
        developer.setDeveloperName("Ranjeet");
        developer.setTeamName("Architecture");
        developer.setProject(project);
        return developer;
    }
}
