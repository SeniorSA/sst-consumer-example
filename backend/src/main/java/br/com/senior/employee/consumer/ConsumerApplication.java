package br.com.senior.employee.consumer;

import br.com.senior.employee.consumer.controller.integration.EmployeeIntegrationController;
import br.com.senior.employee.consumer.controller.LayoutController;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
        applicationContext.getBean(EmployeeIntegrationController.class).consumeOldPendencies();
        applicationContext.getBean(LayoutController.class).consumeOldEvents();
        LOGGER.info("Servidor inicializado com sucesso.");
    }
}
