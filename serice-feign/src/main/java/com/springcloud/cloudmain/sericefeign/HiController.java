package com.springcloud.cloudmain.sericefeign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HiController {
    @Autowired
    SchedualServiceHi schedualServiceHi;
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public  String Hi(@RequestParam("name") String name)
    {
        return  schedualServiceHi.sayHiFromClientOne(name);
    }
}
