package com.in28minutes.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping(path="/helloSunil")
    public String helloSunil()
    {
        return "Hello Sunil";
    }
    @GetMapping(path = "/helloBean")
    public HelloSunilBean helloSunilBean()
    {
        return new HelloSunilBean("Hello Sunil Bean");
    }
}
