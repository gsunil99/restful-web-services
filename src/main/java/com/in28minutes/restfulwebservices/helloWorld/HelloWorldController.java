package com.in28minutes.restfulwebservices.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping(path ="/helloBean/pathVariable/{name}")
    public HelloSunilBean helloSunilPathVariable(@PathVariable String name)
    {
        return new HelloSunilBean(String.format("Hello Sunil, %s",name));
    }
}
