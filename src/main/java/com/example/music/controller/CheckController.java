package com.example.music.controller;

import com.example.music.config.APPConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/music")
//@Service
/* When we annotate Controller with @Service it just registers the class as bean
but spring mvc will not recognize it as controller class so mapping will not
happen and end points will not work
* */
public class CheckController {

    @Value ("${app.name}")
    public String appName;

    @Autowired
    APPConfig appConfig;

    @GetMapping("/appName")
    String  getAppName()
    {
        return appName;
    }

    @GetMapping("/appEnv")
    String  getAppEnv()
    {
        return appConfig.getEnv().toString();
    }

    @PostMapping("/noBody")
    String withoutBody()
    {
        return "post without body sent";
    }

}
