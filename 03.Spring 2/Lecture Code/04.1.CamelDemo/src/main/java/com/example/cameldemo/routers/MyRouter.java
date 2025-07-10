package com.example.cameldemo.routers;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        String sourcePath="src/main/resources/source"  ;
        String destinationPath="src/main/resources/destination"  ;
        from("file:"+sourcePath)
                .log("Message:${body} ${header.CamelFileName}")
                .to("file:"+destinationPath);
    }
}
