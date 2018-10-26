package br.com.senior.employee.consumer;

import br.com.senior.employee.consumer.controller.IntegrationController;
import br.com.senior.employee.consumer.controller.LayoutController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class ConsumerApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ConsumerApplication.class, args);
        applicationContext.getBean(IntegrationController.class).consumeOldPendencies();
        applicationContext.getBean(LayoutController.class).consumeOldEvents();
    }
}
