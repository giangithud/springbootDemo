package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author guoxiong@igetwell.cn
 * @version V1.0
 * @fileName SessionConfig
 * @description maxInactiveIntervalInSeconds: 设置Session失效时间，使用Redis Session之后，原Boot的server.session.timeout属性不再生效
 * 原理：
 * spring-session无缝替换应用服务器的request大概原理是：
 * 1.自定义个Filter，实现doFilter方法 SessionRepositoryFilter
 * 2.继承 HttpServletRequestWrapper 、HttpServletResponseWrapper 类，重写getSession等相关方法(在这些方法里调用相关的 session存储容器操作类)。
 *  SessionRepositoryFilter.this.sessionRepository.save(session); 最终会调用RedisOperationsSessionRepository来保存
 *  getSession() 方法会调用S session = SessionRepositoryFilter.this.sessionRepository.findById(sessionId); 最终调用redis方法处理
 * 3.在 第一步的doFilter中，new 第二步 自定义的request和response的类。并把它们分别传递 到 过滤器链
 * 4.把该filter配置到 过滤器链的第一个位置上
 *
 *
 *
 * @date 2019/8/29 15:08
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400)
public class SessionConfig {
}
