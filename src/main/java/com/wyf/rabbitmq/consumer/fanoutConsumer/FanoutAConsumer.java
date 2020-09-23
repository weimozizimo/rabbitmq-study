package com.wyf.rabbitmq.consumer.fanoutConsumer;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "fanout.a")
public class FanoutAConsumer {

    @RabbitHandler
    public void recived(String msg){
        System.out.println("[fanout.a] recived message: " + msg);
    }
}
