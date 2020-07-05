package com.example.demo.gateway;

import com.example.demo.models.Request;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Payload;

@MessagingGateway
public interface QueueGateway {
	@Gateway(requestChannel = IntegrationFlowDefinitions.HANDLER_FLOW, replyChannel = GatewayChannels.REPLY,replyTimeout = 1000)
	byte[] handle(@Payload Request payload);
}