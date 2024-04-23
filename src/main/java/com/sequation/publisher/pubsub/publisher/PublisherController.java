package com.sequation.publisher.pubsub.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.google.cloud.spring.pubsub.core.PubSubOperations;
import com.google.cloud.spring.pubsub.integration.outbound.PubSubMessageHandler;
import com.sequation.publisher.pubsub.publisher.model.AuditMessage;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.EmitterProcessor;

@Slf4j
@RestController
public class PublisherController {

    // private static final String TOPIC = "poc-messaging";
    // private final PubSubOperations pubSubOperations;

    // public PublisherController(PubSubOperations pubSubOperations) {
    //     // this.pubSubOperations = pubSubOperations;
    // }

    // @Bean
    // public PubSubMessageHandler pubSubMessageHandler() {
    //     return new PubSubMessageHandler(pubSubOperations, TOPIC);
    // }

    // @PostMapping("/publish")
    // public void publishMessage(@RequestBody String message) {
    //     pubSubMessageHandler().handleMessage(new GenericMessage<>(message));
    // }

    @Autowired
	private EmitterProcessor<AuditMessage> postOffice;

	@PostMapping("/postMessage")
	public void sendMessage(
        @RequestBody AuditMessage userMessage) {
		// UserMessage userMessage = new UserMessage(messageBody, username);
		postOffice.onNext(userMessage);
            
    }

}