package com.vishnu.boot.logging.autoconfigure;

import com.vishnu.service.aop.CountableAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class description
 *
 * @author : vishnu.g
 * created on : 03/Sep/2020
 */
@Configuration
@ConditionalOnProperty(name = "logging.api.enabled", havingValue = "true", matchIfMissing = true)
public class MethodCallCounterAutoConfigure {

    private final LoggingProperties properties;

    public MethodCallCounterAutoConfigure(LoggingProperties properties) {
        this.properties = properties;
    }

    @Bean
    public CountableAspect getCountableAspect(){
        return  new CountableAspect(properties.getLoggerName());
    }
}
