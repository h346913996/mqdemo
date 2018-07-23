package com.example.MicServices_2.integrate;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MsgCollectionTwo {

    private Map<String, String> map = new HashMap<String, String>();

    public void changeConfig(String key, String value){
        this.map.put(key, value);
    }

    public String getConfig(String key){
        return this.map.get(key);
    }

    public Map<String, String> getMap(){
        return  map;
    }

}
