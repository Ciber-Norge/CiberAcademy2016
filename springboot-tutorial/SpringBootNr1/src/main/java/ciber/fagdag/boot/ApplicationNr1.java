package ciber.fagdag.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableMongoRepositories
public class ApplicationNr1 extends SpringBootServletInitializer {

    private static Log logger = LogFactory.getLog(ApplicationNr1.class);

    @PostConstruct
    public void logSomething() {
        logger.warn("");
        logger.warn("*********************");
        logger.warn("");
        logger.warn("Velkommen til Fagdag");
        logger.error("Eksempel på logging vha Spring Boot");
        logger.warn("");
        logger.warn("*********************");
        logger.warn("");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationNr1.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationNr1.class, args);
    }

}
