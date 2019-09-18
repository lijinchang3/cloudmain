package com.springcloud.cloudmain.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;
    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hi")
    public String hi(@RequestParam String name)
    {
        return  helloService.hiService(name);
    }
    public String fallback(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
