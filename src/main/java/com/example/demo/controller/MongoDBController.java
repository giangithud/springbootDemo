package com.example.demo.controller;

import com.example.demo.dao.UserMongoDBRepository;
import com.example.demo.entity.User;
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
public class MongoDBController {
    @Autowired
    UserMongoDBRepository userMongoDBRepository;



    @RequestMapping("/mongoDB")
    public String mongoDB() {

        log.info("mongoDB");
        User user = new User();
        user.setId(20L);
        user.setNickName("bear");
        user.setUserName("xiong");
        user.setPassWord("123456");
        userMongoDBRepository.saveUser(user);
        return "success";
    }
    @RequestMapping("/mongoDBFind")
    public User mongoDBFind() {
        return userMongoDBRepository.findUserByUserName("xiong");
    }



}
