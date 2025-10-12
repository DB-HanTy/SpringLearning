
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConsumerTest {

    public static void main(String[] args) throws IOException, TimeoutException {
        // 1.��������
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.�������Ӳ������ֱ��ǣ����������˿ںš�vhost���û���������
        factory.setHost("192.168.85.135");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.��������
        Connection connection = factory.newConnection();

        // 2.����ͨ��Channel
        Channel channel = connection.createChannel();

        // 3.��������
        //TODO:���MQ����ͬ���Ķ��оͻ�ʹ�øö��У�û�оͻᴴ������
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);

        // 4.������Ϣ
		/*
            ����1�����������ѵĶ�������
            ����2���յ���Ϣ���Զ�Ӧ��֪ͨrabbitmq�Զ��޳��Ѿ������ѵ���Ϣ
            ����3���ӿ���Ϣ�Ļص���һ�����������µ���Ϣ�����Զ��ص�DefaultConsumer�����µ�handleDelivery����
            ����Ϣ����δ��뵽�÷�����
         */
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) throws IOException {
                // 5.������Ϣ
                //TODO:body�������Ѷ˽��յ�����Ϣ
                String message = new String(body);
                System.out.println("���յ���Ϣ����" + message + "��");
            }
        });
        System.out.println("�ȴ�������Ϣ��������");
    }
}

