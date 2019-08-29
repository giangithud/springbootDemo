package com.example.demo;

import com.example.demo.properties.PropertiesTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.net.URL;
import java.util.Enumeration;

//org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
/*
@EnableJpaRepositories("com.example.demo.*")
@ComponentScan(basePackages = { "com.example.demo.*" })
@EntityScan("com.example.demo.*")*/
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
