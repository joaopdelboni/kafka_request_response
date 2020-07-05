package com.example.demo.gateway;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface GatewayChannels {
	String REQUEST = "request";
	String REPLY = "reply";

	@Output(REQUEST)
    MessageChannel request();

	@Input(REPLY)
    SubscribableChannel reply();
}
