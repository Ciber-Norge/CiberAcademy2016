package ciber;


import ciber.fagdag.boot.ApplicationNr1;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationNr1.class)
@WebAppConfiguration
@IntegrationTest("server.port=9000")
public class MongoDbTest {

    @Autowired
    private MongoTemplate mongoTemplate;
    private RestTemplate restTemplate = new TestRestTemplate();

    @After
    public void tearDown() throws Exception {
        DB db = mongoTemplate.getDb();
        db.getCollection("Books").remove(new BasicDBObject("title", "snomannen"));
    }

    @Test
    public void mongoDbTest() {
        ResponseEntity<String> entity = restTemplate.
                getForEntity("http://localhost:9000/jersey/webservice/insert/snomannen/nesboe/12/2014/en kriminal historie", String.class);
        assertThat(entity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(entity.getBody().toString()).isEqualTo("false ; test");
    }

}
