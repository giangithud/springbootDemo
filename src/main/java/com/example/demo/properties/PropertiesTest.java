package com.example.demo.properties;

import com.example.demo.entity.User;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName PropertiesTest
 * @description 关于属性文件的学习：https://www.baeldung.com/configuration-properties-in-spring-boot
 * 可以注入map、数组等等
 * @date 2019/8/29 9:49
 */
// 声明是一个配置类
@Configuration
// 申明配置文件对应的位置，一般都不另外起配置文件，都写在application.properties 里面，因为很多默认的auto configuration 都是用前缀的方式取值
@PropertySource(value= "classpath:config/hello.properties")
/** 声明属性的前缀*/
@ConfigurationProperties(prefix = "hello")
@Data
public class PropertiesTest {
    private String nameTest;
    private Integer ageTest;

    private String host;
    private int port;
    private String from;
    private List<String> defaultRecipients;
    private Map<String, String> additionalHeaders;
    private User user;
}
