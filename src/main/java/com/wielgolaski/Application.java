package com.wielgolaski;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@SpringBootApplication
@RestController
public class Application {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${restart.command}")
    String restartCommand;

    @RequestMapping(method = RequestMethod.POST, value = "/restart")
    public void restart() throws IOException {
        logger.info("Run command '{}'", restartCommand);
        Runtime.getRuntime().exec(restartCommand);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


