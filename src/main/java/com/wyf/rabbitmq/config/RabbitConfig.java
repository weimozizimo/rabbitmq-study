package com.wyf.rabbitmq.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {


    /**
    * @Description: 定义demoQueue队列
    * @Param: []
    * @return: org.springframework.amqp.core.Queue
    * @Author: weiyifei
    * @Date: 2020/9/18 17:31
    */
    @Bean
    public Queue demoString(){
        return new Queue("demoQueue");
    }

    //=======================广播模式===========================
    @Bean
    public Queue fanoutA(){
        return new Queue("fanout.a");
    }

    @Bean
    public Queue fanoutB(){
        return new Queue("fanout.b");
    }

    @Bean
    public Queue fanoutC(){
        return new Queue("fanout.c");
    }

    /**
    * @Description: 定义一个fanout交换击
    * @Param: []
    * @return: org.springframework.amqp.core.FanoutExchange
    * @Author: weiyifei
    * @Date: 2020/9/18 17:53
    */

    @Bean
    FanoutExchange fanoutExchange(){
        //定义一个名为fanoutExchange的fanout交换击
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将定义的fanout队列与fanoutExchange绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithA(){
        return BindingBuilder.bind(fanoutA()).to(fanoutExchange());
    }
    /**
     * 将定义的fanout队列与fanoutExchange绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithB(){
        return BindingBuilder.bind(fanoutB()).to(fanoutExchange());
    }
    /**
     * 将定义的fanout队列与fanoutExchange绑定
     * @return
     */
    @Bean
    public Binding bindingExchangeWithC(){
        return BindingBuilder.bind(fanoutC()).to(fanoutExchange());
    }
}
