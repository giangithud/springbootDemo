package com.example.demo.controller;

import com.example.demo.service.MailService;
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
public class MailController {

    @Autowired
    MailService mailService;

    @RequestMapping("/mail")
    public void mail() {
        log.info("mail");
        mailService.sendSimpleMail("924842018@qq.com","你好","  springboot自动发送邮件");
    }


}
