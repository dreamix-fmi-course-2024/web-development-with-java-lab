package bg.fmi.web.lab.raceeventmanagement.config.logger;

import bg.fmi.web.lab.raceeventmanagement.config.AppConfig;
import bg.fmi.web.lab.raceeventmanagement.vo.LoggerLevel;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
@Primary
public class LoggerStdoutImpl implements Logger {

    private final AppConfig appConfig;

    @Autowired
    public LoggerStdoutImpl(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    private LoggerLevel systemLoggerLevel;

    @PostConstruct
    public void setup() {
        systemLoggerLevel = LoggerLevel.valueOf(appConfig.getLogger().getLevel());
    }

    @Override
    public void info(Object toLog) { // LoggerLevel.INFO
//        if (is logger enabled)
        if (LoggerLevel.INFO.getCode().compareTo(systemLoggerLevel.getCode()) <= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void debug(Object toLog) {
        if (LoggerLevel.DEBUG.getCode().compareTo(systemLoggerLevel.getCode()) >= 0) {
            System.out.println(toLog);
        }
    }

    @Override
    public void trace(Object toLog) {

    }

    @Override
    public void error(Object toLog) {
        System.out.println(toLog);
    }
}
