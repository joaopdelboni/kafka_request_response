package com.example.demo.consumer;

import com.example.demo.models.Request;
import com.example.demo.models.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Collections;

@SpringBootApplication(scanBasePackages = "com.example.demo.consumer")
@EnableBinding(Processor.class)
@Slf4j
public class ConsumerApplication {

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Message<Response> load(Message<Request> msg) {
		log.info("Consumer {}", msg);
		Request payload = msg.getPayload();
		Response response = Response.builder()
				.id(payload.getId())
				.message("Message " + payload.getMessageIndex())
				.origin(payload.getOrigin()).build();
		return MessageBuilder.withPayload(response).copyHeaders(msg.getHeaders()).build();
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ConsumerApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "0"));
		app.run(args);
	}
}
