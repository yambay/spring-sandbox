package dev.yambay.springsandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "%s: Hello world!".formatted(SpringSandboxApplication.SOME_UUID);
    }
}
