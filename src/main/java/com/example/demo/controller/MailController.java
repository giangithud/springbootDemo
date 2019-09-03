package com.example.demo.controller;

import com.example.demo.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName HelloWorldController
 * @description
 * 异步发送策略
 * 很多时候邮件发送并不是我们主业务必须关注的结果，比如通知类、提醒类的业务可以允许延时或者失败。
 * 这个时候可以采用异步的方式来发送邮件，加快主交易执行速度，在实际项目中可以采用MQ发送邮件相关参数，监听到消息队列之后启动发送邮件。
 * @date 2019/8/26 23:54
 */
@Slf4j
@RestController
public class MailController {

    @Autowired
    MailService mailService;
    @Autowired
    TemplateEngine templateEngine;

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
    @RequestMapping("/sendTemplateMail")
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("hello", "这里是招呼用语");
        context.setVariable("content", "这里邮件正文");
        // emailTemplate 这个地方会找到emailTemplate.html
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("460893526@qq.com","主题：这是模板邮件",emailContent);
    }


}
