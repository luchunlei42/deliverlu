package org.deliverlu;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@Slf4j
@ServletComponentScan
@SpringBootApplication
public class DeliverluApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliverluApplication.class,args);
        log.info("project starts successfully");
    }
}
