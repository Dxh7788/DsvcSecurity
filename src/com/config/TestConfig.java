package com.config;

import org.otk.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class TestConfig {
	@Bean
	RedisTemplate<String, User> redisTemplateForUser(RedisConnectionFactory jedisConnFactory){
		RedisTemplate<String, User> redisTemplateForUser =new RedisTemplate<String, User>();
		redisTemplateForUser.setConnectionFactory(jedisConnFactory);
		Jackson2JsonRedisSerializer<User> serializer = new Jackson2JsonRedisSerializer<>(User.class);
		redisTemplateForUser.setKeySerializer(serializer);
		redisTemplateForUser.setValueSerializer(serializer);
		redisTemplateForUser.setHashKeySerializer(serializer);
		redisTemplateForUser.setHashValueSerializer(serializer);
		return redisTemplateForUser;
	}
}
