package com.example.MicServices_2.integrate;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class QueueSender {

    @Autowired
    private AmqpTemplate rabbitTemplate; // 默认实现的mq发送类

    public String send(String msg,String routing) {
        msg += " - by sender:" + new Date();
        this.rabbitTemplate.convertAndSend(routing, msg); // routingKey指定消息接受者
        return "routing单对单发送参数。sender发出了消息:" + msg;
    }

    public String sendUseExchange(String msg,String routing) {
        msg += " - by sender:" + new Date();
        this.rabbitTemplate.convertAndSend("exchange", routing, msg);
        return "exchange单对单发送参数。sender发出了消息:" + msg;
    }
}
