package rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import rest.repo.AbfrageRepo;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    /**
     *  Method saves some demo data for test purposes in repository
     */
    @Profile("DEV") @Bean
    public CommandLineRunner storeSomeDemoData(AbfrageRepo repo) {
        return args -> repo.saveAll(DemoData.getDemoData());
    }
}
