package com.sequation.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sequation.publisher.pubsub.publisher.model.AuditMessage;

import reactor.core.publisher.EmitterProcessor;

@SpringBootApplication
public class PublisherApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}
	@Bean
	public EmitterProcessor<AuditMessage> postOffice() {
		return EmitterProcessor.create();
	}


	
}
