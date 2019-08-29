package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Author guoxiong@igetwell.cn
 * @Description 配置很简单：引入jar，添加一个@EnableRedisHttpSession配置类即可，
 * @Date 20:52 2019/8/29
 * @Param 
 * @return 
 **/
@RestController
public class SessionController {
    /**
     * @Author guoxiong@igetwell.cn
     * @Description 测试方法为本地mvn打一个jar包，然后idea启动一个，两个端口配置不一样就可以了
     * @Date 20:52 2019/8/29
     * @Param [session]
     * @return java.lang.String
     **/
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
