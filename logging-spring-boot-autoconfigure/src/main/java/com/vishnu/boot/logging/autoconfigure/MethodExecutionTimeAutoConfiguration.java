package com.vishnu.boot.logging.autoconfigure;

import com.vishnu.service.aop.LoggableMethodExecutionTimeAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class to conditionally load Aspect class.
 *
 * @author : vishnu.g
 * created on : 02/Sep/2020
 */
@Configuration
@ConditionalOnClass(LoggableMethodExecutionTimeAspect.class)
@EnableConfigurationProperties(LoggingProperties.class)
public class MethodExecutionTimeAutoConfiguration {

    private final LoggingProperties properties;

    public MethodExecutionTimeAutoConfiguration(LoggingProperties properties) {
        this.properties = properties;
    }

    @Bean
    public LoggableMethodExecutionTimeAspect loggableMethodExecutionTimeAspect(){
        return new LoggableMethodExecutionTimeAspect(properties.getLoggerName());
    }
}
