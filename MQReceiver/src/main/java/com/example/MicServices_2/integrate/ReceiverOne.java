package com.example.MicServices_2.integrate;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RabbitListener(queues = "Queue1")
public class ReceiverOne {

    @Autowired
    private MsgCollectionOne msgCollectionOne;

    @RabbitHandler
    public void process(String Queue1) {
        msgCollectionOne.changeConfig("receiver1:"+new Date(),Queue1);
    }

}
