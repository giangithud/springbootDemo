package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName SchedulerTask
 * @description 定时任务配置非常简单，在启动类上面声明@EnableScheduling ，然后在bean里面加上@Scheduled的注解即可
 * @date 2019/9/2 21:40
 */
@Component
public class SchedulerTask {
    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        System.out.println("this is scheduler task runing  "+(count++));
    }
}
