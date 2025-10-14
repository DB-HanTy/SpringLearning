package com.itheima.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

//将当前类放到SpringIOC容器中
@Component
public class SpringRabbitListener {
    //监听名称simple.queue队列，Spring只要接收到该队列的消息就会接收消息
//    @RabbitListener(queues = "simple.queue")
//    //Spring自动将接收的消息给方法参数msg
//    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
//        System.out.println("spring消费者收到simple.queue的消息：{" + msg + "}");
//    }
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue1(String msg) throws InterruptedException {
        System.out.println("消费者1收到simple.queue的消息：{" + msg + "}" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueue2(String msg) throws InterruptedException {
        System.err.println("消费者2收到simple.queue的消息：{" + msg + "}" + LocalTime.now());
        Thread.sleep(200);
    }
}
