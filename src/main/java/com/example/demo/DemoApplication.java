package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.URL;
import java.util.Enumeration;

//org.springframework.boot.autoconfigure.domain.EntityScan;
// @MapperScan配置mapper扫描路径；如果不配置扫描，可以在类上面加上@Mapper注解
// @EnableScheduling开启定时任务
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableScheduling
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        DemoApplication demoApplication = new DemoApplication();
        try {
            Enumeration<URL> urls = demoApplication.getClass().getClassLoader().getResources("META-INF/spring.factories");
            System.out.println("urls:" + urls);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                System.out.println("urlItem:"+url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
