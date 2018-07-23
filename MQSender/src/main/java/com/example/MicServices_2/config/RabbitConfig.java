package com.example.MicServices_2.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue Queue1() {
        return new Queue("Queue1");  // 创建一个消息队列，监听了该消息队列的客户端可以收到消息
    }

    @Bean
    public Queue Queue2() {
        return new Queue("Queue2");  // 创建一个消息队列，监听了该消息队列的客户端可以收到消息
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    } // 广播模式

    @Bean
    Binding bindingExchange1(Queue Queue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue1).to(fanoutExchange);
    }  //绑定消息队列和交换机

    @Bean
    Binding bindingExchange2(Queue Queue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(Queue2).to(fanoutExchange);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    } // 通配符匹配机制

    @Bean
    Binding bindingExchangeQueue1(Queue Queue1, TopicExchange exchange) {
        return BindingBuilder.bind(Queue1).to(exchange).with("Queue1");
    }

    @Bean
    Binding bindingExchangeQueue2(Queue Queue2, TopicExchange exchange) {
        return BindingBuilder.bind(Queue2).to(exchange).with("Queue2");
    }

    @Bean
    Binding bindingExchangeQueue12(Queue Queue1, TopicExchange exchange) {
        return BindingBuilder.bind(Queue1).to(exchange).with("test.#");
    }
}
