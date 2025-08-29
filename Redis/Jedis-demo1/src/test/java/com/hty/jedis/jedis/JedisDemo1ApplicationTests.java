package com.hty.jedis.jedis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;

import java.util.Map;

@SpringBootTest
class JedisDemo1ApplicationTests {
	private Jedis jedis;

	@BeforeEach
	void setUp() {
		//1、建立连接
		jedis = new Jedis("192.168.85.130", 6379);
		//2、设置密码
		jedis.auth("123456");
		//3、选择数据库
		jedis.select(0);

	}
	@Test
	void testString() {
		//存入数据
		String result = jedis.set("name", "zhangsan");
		System.out.println("result="+result);
		//获取数据
		String name = jedis.get("name");
		System.out.println("name="+name);
	}
	@Test
	void testHash() {
		//存数据
		jedis.hset("user:1", "name", "Jack");
		jedis.hset("user:1", "age", "18");
		//取数据
		Map<String, String> map = jedis.hgetAll("user:1");
		System.out.println(map);
	}
	@AfterEach
	void tearDown() {
		if (jedis != null) {
			jedis.close();
		}
	}

}
