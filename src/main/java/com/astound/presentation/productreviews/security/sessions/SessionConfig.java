//package com.astound.presentation.productreviews.security.sessions;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.security.web.session.HttpSessionEventPublisher;
//import org.springframework.session.SessionRepository;
//import org.springframework.session.data.redis.RedisOperationsSessionRepository;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.HeaderHttpSessionStrategy;
//import org.springframework.session.web.http.HttpSessionStrategy;
//
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3600, redisNamespace = "secmess")
//public class SessionConfig {
//    @Bean
//    public HttpSessionEventPublisher httpSessionEventPublisher() {
//        return new HttpSessionEventPublisher();
//    }
//
//    @Bean
//    public JedisConnectionFactory connectionFactory() throws Exception {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public HttpSessionStrategy httpSessionStrategy() {
//        return new HeaderHttpSessionStrategy();
//    }
//
//    @Primary
//    @Bean
//    public SessionRepository primarySessionRepository(RedisOperationsSessionRepository delegate) {
//        return new InvalidClassExceptionSafeRepository(delegate);
//    }
//}
