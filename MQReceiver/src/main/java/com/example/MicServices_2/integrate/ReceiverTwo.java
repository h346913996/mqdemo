package com.example.MicServices_2.integrate;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "Queue2")
public class ReceiverTwo {

    @Autowired
    private MsgCollectionTwo msgCollectionTwo;

    @RabbitHandler
    public void process(String Queue2) {
        msgCollectionTwo.changeConfig("receiver2:"+new Date(),Queue2);
    }

}
