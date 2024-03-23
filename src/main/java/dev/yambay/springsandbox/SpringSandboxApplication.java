package dev.yambay.springsandbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class SpringSandboxApplication {
    public static final String SOME_UUID = java.util.UUID.randomUUID().toString();

    public static void main(String[] args) {
        SpringApplication.run(SpringSandboxApplication.class, args);
    }

}
