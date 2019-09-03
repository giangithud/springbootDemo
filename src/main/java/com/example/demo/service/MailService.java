package com.example.demo.service;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName MailService
 * @description 注释
 * @date 2019/9/2 21:51
 */
public interface MailService {
    /**普通邮件模板*/
    void sendSimpleMail(String to, String subject, String content);
    /**发送内容为html格式的邮件*/
    void sendHtmlMail(String to, String subject, String content);
    /**发送带附件的邮件*/
    void sendAttachmentsMail(String to, String subject, String content, String filePath);
    /**发送带静态资源的邮件*/
    void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
