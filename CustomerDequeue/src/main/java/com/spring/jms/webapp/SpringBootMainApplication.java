package com.spring.jms.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//private static final Logger logger = LoggerFactory.getLogger(SpringBootMainApplication.class);

@SpringBootApplication
@PropertySource(value = "file:config/application.properties")
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
//@EnableJpaRepositories
public class SpringBootMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMainApplication.class, args);
        System.out.println("<<<<<<<<<<<<<<<<< Application Start >>>>>>>>>>>>>>>>>>");
    }
}