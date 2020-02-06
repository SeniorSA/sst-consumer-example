package br.com.senior.employee.consumer;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j
@SpringBootApplication
@EnableAutoConfiguration
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);

        LOGGER.info("Servidor inicializado com sucesso.");
    }
}
