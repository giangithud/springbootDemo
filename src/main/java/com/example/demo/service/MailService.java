package com.example.demo.service;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName MailService
 * @description 注释
 * @date 2019/9/2 21:51
 */
public interface MailService {
    void sendSimpleMail(String to, String subject, String content);
}
