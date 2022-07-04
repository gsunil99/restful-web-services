package com.in28minutes.restfulwebservices.helloWorld;


public class HelloSunilBean {
    private String message;
    public HelloSunilBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloSunilBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
