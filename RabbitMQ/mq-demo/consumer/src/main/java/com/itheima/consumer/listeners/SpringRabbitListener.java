package com.itheima.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//将当前类放到SpringIOC容器中
@Component
public class SpringRabbitListener {
    //监听名称simple.queue队列，Spring只要接收到该队列的消息就会接收消息
    @RabbitListener(queues = "simple.queue")
    //Spring自动将接收的消息给方法参数msg
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("spring消费者收到simple.queue的消息：{" + msg + "}");
    }
}
