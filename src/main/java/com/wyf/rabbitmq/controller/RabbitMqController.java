package com.wyf.rabbitmq.controller;


import com.wyf.rabbitmq.producer.RabbitProducer;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "普通队列模式")
@RestController
@RequestMapping("/")
public class RabbitMqController {

    @Autowired
    private RabbitProducer rabbitProducer;

    @GetMapping("/sendDemoQueue")
    public Object sendDemoQueue(){
        rabbitProducer.sendDemoQueue();
        return "success";
    }

    @GetMapping("/sendFanout")
    public Object sendFanout(){
        rabbitProducer.sendFanout();
        return "success";
    }
}
