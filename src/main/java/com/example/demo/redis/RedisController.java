package com.example.demo.redis;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName HelloWorldController
 * @description 注释
 * @date 2019/8/26 23:54
 */
// 自动注入 log
@Slf4j
@RestController
public class RedisController {
    /**
     * 注入redis操作模板
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/redis")
    @Transactional
    public String redis() {
        log.info("redis");
        stringRedisTemplate.opsForValue().set("userName", "bear");

        User user2 = new User("aa1", "aa@126.com", "aa", "aa123456", "");
        // redis 存对象
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        operations.set("UserString", user2);

        redisTemplate.opsForHash().putIfAbsent("user hash","userName",user2.getNickName());
        redisTemplate.opsForHash().putIfAbsent("user hash","email",user2.getEmail());

        // 缓存管理
        // 有缓存的情况下，已经不会从mysql里面查询数据了，看日志可以发现已经不打印sql了
        User bear = userRepository.findByUserName("bear");

        userRepository.updateByUserName("bear");

        return redisTemplate.opsForValue().get("UserString").toString()+"<br /> 缓存数据"+bear.toString();
    }
}
