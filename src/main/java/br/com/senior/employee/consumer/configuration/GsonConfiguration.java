package br.com.senior.employee.consumer.configuration;

import br.com.senior.employee.consumer.rest.json.DtoJsonConverter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Configuration
public class GsonConfiguration {

    @Bean
    public Gson getGson() {
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(Date.class, new DtoJsonConverter.DateTimeAdapter());
        builder.registerTypeAdapter(LocalDate.class, new DtoJsonConverter.DateAdapter());
        builder.registerTypeAdapter(LocalTime.class, new DtoJsonConverter.TimeAdapter());
        builder.registerTypeAdapter(byte[].class, new DtoJsonConverter.BlobAdapter());
        builder.registerTypeAdapter(Instant.class, new DtoJsonConverter.InstantAdapter());
        builder.registerTypeHierarchyAdapter(Object.class, new DtoJsonConverter.ObjectAdapter());

        return builder.create();
    }
}