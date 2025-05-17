package com.infosys.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.infosys.beans")  // tells whereto scan for beans
public class AppConfig {
}
