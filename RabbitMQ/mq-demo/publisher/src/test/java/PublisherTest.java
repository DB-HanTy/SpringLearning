import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherTest {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 1.��������
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.�������Ӳ������ֱ��ǣ����������˿ںš�vhost���û���������
        factory.setHost("192.168.85.135");
        //���ͺͽ�����Ϣ�Ķ˿ں�
        factory.setPort(5672);
        //���������ĵ�ַ
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.��������
        Connection connection = factory.newConnection();

        // 2.����ͨ��Channel
        Channel channel = connection.createChannel();

        // 3.��������
		/*
            ��������
                ����1�����е����� queueName
                ����2�������Ƿ�֧�ֳ־û� false�����־û�����
                ����3�������Ƿ��������Ƿ�����������connection�µ�channel����
                ����4���Ƿ����ʱ�Զ�ɾ���������һ��consumer(������)�Ͽ�֮�󣬶��н��Զ�ɾ����
                ����5��������rabbitmq��һ����չ�����ܷǳ�ǿ�󣬻�����AMPQ��û�еġ����������ȴ���null
         */
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);

        // 4.������Ϣ
        String message = "hello, rabbitmq!";
        /*
            ������Ϣ��
                ����1��exchange ������ û�о�����Ϊ "" ֵ�Ϳ�����
                ����2��routingKey ·�ɵ�key ����û������key��ֱ��ʹ�ö��е�����queueName
                ����3���������ݵ����е�ʱ���Ƿ�Ҫ��һЩ������ֱ�Ӹ�ֵnull����
                ����4��body ������з��͵���Ϣ����
         */
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("������Ϣ�ɹ�����" + message + "��");

        // 5.�ر�ͨ��������
        channel.close();
        connection.close();

    }
}

