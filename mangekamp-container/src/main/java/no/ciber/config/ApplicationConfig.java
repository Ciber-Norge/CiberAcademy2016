package no.ciber.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("no.ciber.repositories")
public class ApplicationConfig {

	public ApplicationConfig() {
	}
}
