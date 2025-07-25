package com.example.demo_log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private static final Logger logger= LoggerFactory.getLogger(DemoController.class);

    @ResponseBody
    @RequestMapping("/")
    public String testMethod() {
        logger.trace("this is trace log example");
        logger.info("this is info log example");
        logger.debug("this is debug log example");
        logger.error("this is error log example");
        logger.warn("this is warn log example");

        return "check the console log";
    }
}
