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
        mailService.sendSimpleMail("460893526@qq.com","hello","  springboot自动发送邮件");
    }

    @RequestMapping("/mailHtml")
    public void mailHtml() {
        log.info("mailHtml");
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("460893526@qq.com","hello",content);
    }
    @RequestMapping("/mailAttach")
    public void sendAttachmentsMail() {
        log.info("mailHtml");
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是Html格式并带有附件的邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        String filePath="C:\\Users\\Thinkpad\\Desktop\\公司相关材料\\bz.jpg";
        mailService.sendAttachmentsMail("460893526@qq.com","hello",content,filePath);
    }

    @RequestMapping("/mailResource")
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath="C:\\Users\\Thinkpad\\Desktop\\公司相关材料\\bz.jpg";
        mailService.sendInlineResourceMail("460893526@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


}
