package br.com.senior.employee.consumer.configuration;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4jConfiguration {

    public Log4jConfiguration() {
        BasicConfigurator.configure();
    }
}
