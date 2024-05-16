package bg.fmi.web.lab.raceeventmanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig { // c
    private LoggerConfig logger = new LoggerConfig();

    @Data
//    @ConfigurationProperties(prefix = "logger.info")
    public class LoggerConfig {
        private String level;
    }
}