package com.example.cameldemo.routers;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.StringTokenizer;

@Component
public class MyTransformRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        String sourcePath="src/main/resources/source";
        String destinationPath="src/main/resources/destination";

        from("file:"+sourcePath)
        .log("Message:${body} ${header.CamelFileName}")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        // Read input message from source
                        Message inputMessage= exchange.getIn();
                        // read body of input message
                        String inputMessageBody= inputMessage.getBody(String.class);
                        // 10,20,hi -->{age:10,salary:20,name:hi}
                        StringTokenizer stringTokenizer = new StringTokenizer(inputMessageBody,",");
                        String age =  stringTokenizer.nextToken();
                        String salary = stringTokenizer.nextToken();
                        String name = stringTokenizer.nextToken();

                        String outputData="{age:"+age+",salary:"+salary+",name:"+name+"}";
                        Message outputMessage= exchange.getMessage();
                        outputMessage.setBody(outputData);
                    }
                })
                .to("file:"+destinationPath);
    }
}
