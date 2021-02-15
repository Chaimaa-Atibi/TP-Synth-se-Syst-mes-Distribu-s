package org.sid.consumerservice;

import org.apache.commons.math3.analysis.function.Cos;
import org.sid.consumerservice.entities.Costumer;
import org.sid.consumerservice.repository.ConsumerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ConsumerRepository consumerRepository,
                            RepositoryRestConfiguration restConfiguration) {
        restConfiguration.exposeIdsFor(Costumer.class);
        return args -> {
            consumerRepository.save(new Costumer(null,"Chaimaa", "chaimaa@gmail.com"));
            consumerRepository.save(new Costumer(null,"Yassine", "yassine@gmail.com"));
            consumerRepository.save(new Costumer(null,"Youssra", "youssra@gmail.com"));
            consumerRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });

        };
    }

}
