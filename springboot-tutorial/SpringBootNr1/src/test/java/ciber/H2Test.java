package ciber;

import ciber.fagdag.boot.ApplicationNr1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationNr1.class)
@WebAppConfiguration
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")})
public class H2Test {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void checkDatabaseHasValues() {

        String selectQuery = "SELECT * from PERSON WHERE PERSONID = 1";

        List<Map<String, Object>> resultSet = jdbcTemplate
                .queryForList(selectQuery);

        System.out.println(resultSet);
        assertThat(resultSet.isEmpty()).isFalse();
        Object firstname = resultSet.get(0).get("FIRSTNAME").toString();
        assertThat(firstname.equals("Fred"));

    }
}

