package com.wyf.rabbitmq.consumer.fanoutConsumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.b")
public class FanoutBConsumer {

    @RabbitHandler
    public void recived(String msg){
        System.out.println("[fanout.b] recived message: " + msg);
    }
}
