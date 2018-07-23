package com.example.MicServices_2.integrate;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BroadcastSender {

    @Autowired
    private AmqpTemplate rabbitTemplate; // 默认实现的mq发送类

    public String send(String msg) {
        msg += " - by sender:" + new Date();
        this.rabbitTemplate.convertAndSend("fanoutExchange","", msg);
        return  "广播发送。Sender发出了消息:" + msg;
    }
}
