package com.rohid;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.rohid.model.Item;

@SpringBootApplication
public class App {

	@Bean
	public JedisConnectionFactory connectionFactory() {
	  JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
	  connectionFactory.setHostName("redis.alhdro.ng.0001.usw1.cache.amazonaws.com");
	  connectionFactory.setPort(6379);
	  //connectionFactory.setPassword("password");
	 
	  return connectionFactory;
	}

	@Bean
	RedisTemplate<String, Item> redisTemplate(){
		RedisTemplate<String,Item> redisTemplate = new RedisTemplate<String, Item>();
		redisTemplate.setConnectionFactory(connectionFactory());
		return redisTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}