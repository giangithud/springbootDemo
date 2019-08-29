package com.example.demo.controller;

import com.example.demo.model.Constant;
import com.example.demo.properties.PropertiesTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName HelloWorldController
 * @description 注释
 * @date 2019/8/26 23:54
 */
@Slf4j
@RestController
public class HelloWorldController {
    // private static final Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @Autowired
    Constant constant;
    @Autowired
    PropertiesTest propertiesTest;


    @RequestMapping("/hello")
    public String index(){
        log.info("index");
        log.error("index");
        return "Hello World devtools "+constant.getVal()+"propertiesTest="+propertiesTest.getNameTest();
    }
}
