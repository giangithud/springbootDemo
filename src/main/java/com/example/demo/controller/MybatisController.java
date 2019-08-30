package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author guoxiong@igetwell.cn
 * @Description mybatis相关配置，只需要加入mybatis-spring-boot  jar，然后启动类加入mapperScan路径即可
 * @Date 20:52 2019/8/29
 * @Param 
 * @return 
 **/
@Slf4j
@RestController
public class MybatisController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("/mybatis")
    String mybatis() {
        User oneXml = userMapper.getOneXml(12L);
        log.info("oneXml.toString()"+oneXml.toString());
        return userMapper.getOne(12L).toString();
    }
}
