package com.sequation.publisher.pubsub.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class Source {
    @Autowired
    private StreamBridge streamBridge;

    public boolean sendMessageToTopic( String topicName,Object message) {
       return  streamBridge.send(topicName, message);
    }
}
