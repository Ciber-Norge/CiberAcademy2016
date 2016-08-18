package ciber.fagdag.boot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ApplicationNr3 extends SpringBootServletInitializer {

    private static Log logger = LogFactory.getLog(ApplicationNr3.class);


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationNr3.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationNr3.class, args);
    }

}
