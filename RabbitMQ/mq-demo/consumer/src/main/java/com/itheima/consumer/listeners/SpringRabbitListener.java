package com.itheima.consumer.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//����ǰ��ŵ�SpringIOC������
@Component
public class SpringRabbitListener {
    //��������simple.queue���У�SpringֻҪ���յ��ö��е���Ϣ�ͻ������Ϣ
    @RabbitListener(queues = "simple.queue")
    //Spring�Զ������յ���Ϣ����������msg
    public void listenSimpleQueueMessage(String msg) throws InterruptedException {
        System.out.println("spring �����߽��յ���Ϣ����" + msg + "��");
    }
}
