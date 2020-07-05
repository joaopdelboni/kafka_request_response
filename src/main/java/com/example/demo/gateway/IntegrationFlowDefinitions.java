package com.example.demo.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.HeaderEnricherSpec;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.json.ObjectToJsonTransformer;

@Configuration
public class IntegrationFlowDefinitions {

	public static final String HANDLER_FLOW = "handlerFlow";

	@Bean
	public IntegrationFlow requestsFlow() {
		return IntegrationFlows.from(HANDLER_FLOW).enrichHeaders(HeaderEnricherSpec::headerChannelsToString)
				.transform(new ObjectToJsonTransformer()).channel(GatewayChannels.REQUEST).get();
	}
}
