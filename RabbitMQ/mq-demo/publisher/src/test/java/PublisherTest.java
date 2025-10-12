import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class PublisherTest {
    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 1.建立连接
        ConnectionFactory factory = new ConnectionFactory();
        // 1.1.设置连接参数，分别是：主机名、端口号、vhost、用户名、密码
        factory.setHost("192.168.85.135");
        //发送和接收消息的端口号
        factory.setPort(5672);
        //虚拟主机的地址
        factory.setVirtualHost("/");
        factory.setUsername("itcast");
        factory.setPassword("123321");
        // 1.2.建立连接
        Connection connection = factory.newConnection();

        // 2.创建通道Channel
        Channel channel = connection.createChannel();

        // 3.创建队列
		/*
            声明队列
                参数1：队列的名称 queueName
                参数2：队列是否支持持久化 false：不持久化处理
                参数3：队列是否排它：是否允许其它的connection下的channel连接
                参数4：是否空闲时自动删除，当最后一个consumer(消费者)断开之后，队列将自动删除。
                参数5：参数是rabbitmq的一个扩展，功能非常强大，基本是AMPQ中没有的。这里我们先传递null
         */
        String queueName = "simple.queue";
        channel.queueDeclare(queueName, false, false, false, null);

        // 4.发送消息
        String message = "hello, rabbitmq!";
        /*
            发送消息：
                参数1：exchange 交换机 没有就设置为 "" 值就可以了
                参数2：routingKey 路由的key 现在没有设置key，直接使用队列的名字queueName
                参数3：发送数据到队列的时候，是否要带一些参数。直接赋值null即可
                参数4：body 向队列中发送的消息数据
         */
        channel.basicPublish("", queueName, null, message.getBytes());
        System.out.println("发送消息成功：【" + message + "】");

        // 5.关闭通道和连接
        channel.close();
        connection.close();

    }
}

