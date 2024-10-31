package com.example.domain.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    private static final Logger logger = LoggerFactory.getLogger(CamelConfig.class);

    @Bean
    public CamelContext camelContext() {
        return new DefaultCamelContext();
    }

    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                logger.info("Camel context is about to start");
                // Add any custom configuration here
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
                logger.info("Camel context has started");
                // Add any custom configuration here
            }
        };
    }
}