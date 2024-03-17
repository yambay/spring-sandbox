package dev.yambay.springsandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class SimpleController {
    private static final String SOME_UUID = java.util.UUID.randomUUID().toString();

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "%s: Hello world!".formatted(SOME_UUID);
    }
}
