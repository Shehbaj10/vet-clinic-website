package au.edu.rmit.sept.webapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManagerFactory;

@Configuration
public class NoOpJpaConfig {

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        // Return null or a mock factory if not needed
        return null;
    }
}

