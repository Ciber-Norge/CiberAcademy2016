package ciber;

import ciber.fagdag.boot.ApplicationNr1;
import ciber.fagdag.boot.domain.Health;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationNr1.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class HealthControllerIntegrationTest {
    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void jerseyHealth() {
        ResponseEntity<Health> entity = restTemplate.getForEntity("http://localhost:9000/jersey/health", Health.class);
        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Jersey: Up and Running!");
    }


    @Test
    public void springHealth() {
        ResponseEntity<Health> entity = restTemplate.getForEntity("http://localhost:9000/spring/health", Health.class);
        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().getStatus()).isEqualTo("Spring MVC: Up and Running!");
    }

}
