package com.example.MicServices_2.routes.mq;

import com.example.MicServices_2.integrate.MsgCollectionOne;
import com.example.MicServices_2.integrate.MsgCollectionTwo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MQReceiverController {

    @Autowired
    private MsgCollectionOne msgCollectionOne;

    @Autowired
    private MsgCollectionTwo msgCollectionTwo;

    @RequestMapping(value = "/ReceiverOne",method = RequestMethod.GET)
    @ResponseBody
    public Object receiverOne(){
        return msgCollectionOne.getMap();
    }

    @RequestMapping(value = "/ReceiverTwo",method = RequestMethod.GET)
    @ResponseBody
    public Object receiverTwo(){
        return msgCollectionTwo.getMap();
    }
}
