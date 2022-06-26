package com.springboot.schoolinfo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }

    /*@Bean
    WebClient webClient(LoadBalancerClient loadBalancerClient) {
        return WebClient.builder()
                .filter(new LoadBalancerExchangeFilterFunction(loadBalancerClient))
                .build();*/
}
