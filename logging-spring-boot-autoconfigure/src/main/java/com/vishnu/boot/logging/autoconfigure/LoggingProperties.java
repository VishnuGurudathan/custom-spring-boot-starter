package com.vishnu.boot.logging.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Property class to set LoggingProperties.
 *
 * @author : vishnu.g
 * created on : 02/Sep/2020
 */
@ConfigurationProperties("logging.track")
public class LoggingProperties {
    private String loggerName = "AuditLogger";

    public String getLoggerName() {
        return loggerName;
    }

    public void setLoggerName(String loggerName) {
        this.loggerName = loggerName;
    }
}
