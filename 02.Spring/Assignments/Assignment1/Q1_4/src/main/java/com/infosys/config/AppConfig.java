package com.infosys.config;

import com.infosys.beans.Address;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.infosys.beans")
public class AppConfig {
    @Bean
    public Address address() {
        Address address = new Address();
        address.setStreet("FC Road");
        address.setCity("Pune");
        address.setState("Maharashtra");
        address.setZipcode("411018");
        return address;
    }
}
