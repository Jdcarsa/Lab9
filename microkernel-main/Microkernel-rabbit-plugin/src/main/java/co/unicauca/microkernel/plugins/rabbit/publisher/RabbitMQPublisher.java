package co.unicauca.microkernel.plugins.rabbit.publisher;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RabbitMQPublisher implements IPublisherPlugin {

    private final static String QUEUE_NAME = "envios";

    @Override
    public void publish(String msg) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try ( Connection connection = factory.newConnection();  
            Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes("UTF-8"));
            System.out.println(" [x] Sent message:");
            System.out.println("--------------------------------");
            String[] parts = msg.split(",");
                for (String part : parts) {
                    System.out.println(part.trim());
                }
            System.out.println("--------------------------------");
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitMQPublisher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

       
