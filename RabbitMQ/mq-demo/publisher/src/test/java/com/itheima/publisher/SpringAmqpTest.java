package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage2Queue() {
        String queueName = "simple.queue";
        String msg = "hello, amqp!";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    //发送50条消息
    @Test
    void testWorkQueue() throws InterruptedException {
        String queueName = "simple.queue";
        String msg = "hello, worker, message_";
        for (int i = 1; i <= 50; i++) {
            rabbitTemplate.convertAndSend(queueName, msg + i);
            Thread.sleep(20);
        }
    }


    @Test
    void testSendFanout() {
        String exchangeName = "itcast.fanout";
        String msg = "hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, null, msg);
    }

    @Test
    void testSendDirect() {
        String exchangeName = "itcast.direct";
        String msg = "hello,red";
        rabbitTemplate.convertAndSend(exchangeName, "red", msg);
    }

    @Test
    void testSendTopic() {
        String exchangeName = "hmall.topic";
        String msg = "今天天气挺不错，我的心情的挺好的";
        rabbitTemplate.convertAndSend(exchangeName, "china.weather", msg);
    }

    @Test
    void testSendObject() {
        Map<String, Object> msg = new HashMap<>(2);
        msg.put("name", "jack");
        msg.put("age", 21);
        rabbitTemplate.convertAndSend("object.queue", msg);
    }
}


