package rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import rest.pojo.AbfStandHausm;
import rest.repo.AbfrageRepo;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demoData(AbfrageRepo repo) {
        return args -> {
            // let's save couple records in repo (db)
            repo.save(new AbfStandHausm(123, "Some address"));
            repo.save(new AbfStandHausm(321, "address2"));
            repo.save(new AbfStandHausm(1, "Some address 3"));
        };
    }
}
