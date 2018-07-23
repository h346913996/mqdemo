package com.example.MicServices_2.routes.mq;

import com.example.MicServices_2.integrate.BroadcastSender;
import com.example.MicServices_2.integrate.QueueSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MQSenderController {

    @Autowired
    private QueueSender queueSender;
    @Autowired
    private BroadcastSender broadcastSender;

    @RequestMapping(value = "/sayhello",method = RequestMethod.GET)
    public String sendMQ(@RequestParam(value="msg",required=true) String msg,@RequestParam(value="sender",required=true) String sender,@RequestParam(value="exchange",required=false,defaultValue = "false") String exchange,@RequestParam(value="routing",required=false,defaultValue = "rt1") String routing){
        String returnmsg = "啥也没做";
        switch (sender){
            case "1" :{
                if(exchange.equals("false")){
                    returnmsg = queueSender.send(msg,"Queue2");
                } else {
                    returnmsg = queueSender.sendUseExchange(msg,routing);
                }
                break;
            }
            case "2" :{
                if(exchange.equals("false")){
                    returnmsg = queueSender.send(msg,"Queue1");
                } else {
                    returnmsg = queueSender.sendUseExchange(msg,routing);
                }
                break;
            }
            case "3" :{
                if(exchange.equals("false")){
                    returnmsg = broadcastSender.send(msg);
                } else {
                    returnmsg = broadcastSender.send(msg);
                }
                break;
            }
        }
        return returnmsg;
    }

}
