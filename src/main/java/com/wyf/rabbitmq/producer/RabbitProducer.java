package com.wyf.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RabbitProducer {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendDemoQueue(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[demoQueue] send msg:"+dateString);
        //第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend("demoQueue",dateString);
    }

    public void sendFanout(){
        Date date = new Date();
        String dateString = new SimpleDateFormat("YYYY-mm-DD hh:MM:ss").format(date);
        System.out.println("[fanoutQueue] send msg:"+dateString);
        // 注意 第一个参数是我们交换机的名称 ，第二个参数是routerKey 我们不用管空着就可以，第三个是你要发送的消息
        //由于这个是广播模式，所以routekey没有意义
        this.rabbitTemplate.convertAndSend("fanoutExchange","",dateString);
    }
}
