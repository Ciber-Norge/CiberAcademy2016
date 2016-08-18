package ciber.fagdag.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationNr2 extends SpringBootServletInitializer {

    private static Log logger = LogFactory.getLog(ApplicationNr2.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationNr2.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationNr2.class, args);
    }

}
