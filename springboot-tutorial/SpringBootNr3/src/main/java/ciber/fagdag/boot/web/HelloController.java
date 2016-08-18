package ciber.fagdag.boot.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(value = "/", produces = "application/json") // Spring MVC
    public String halloFagdag() {
        return "Fagdag Oppgave : Spring Boot sier 'Hello World' ";
    }
}
