package com.infosys.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.infosys.beans")
public class AppConfig {

}
