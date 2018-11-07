package br.com.senior.employee.consumer;

import br.com.senior.employee.consumer.client.esocial.XmlSituation;
import br.com.senior.employee.consumer.configuration.ApplicationProperties;
import br.com.senior.employee.consumer.controller.integration.employee.EmployeeIntegrationController;
import br.com.senior.employee.consumer.controller.integration.esocial.EsocialIntegrationController;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@Log4j
@SpringBootApplication
@EnableAutoConfiguration
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsumerApplication.class, args);
        applicationContext.getBean(EmployeeIntegrationController.class).consumeEmployeeIntegrations();
        applicationContext.getBean(EsocialIntegrationController.class).consumePendenciesStatusIntegration();
        applicationContext.getBean(EsocialIntegrationController.class).consumePendenciesReturnGovernment();

        LOGGER.info("Servidor inicializado com sucesso.");
    }
}
