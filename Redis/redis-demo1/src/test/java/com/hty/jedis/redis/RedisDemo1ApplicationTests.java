package com.hty.jedis.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemo1ApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void textString() {
		//写入一条String数据
		redisTemplate.opsForValue().set("name", "张三");
		//获取String数据
		Object name = redisTemplate.opsForValue().get("name");
		System.out.println("name = " + name);
	}

}