package com.au.autogen;

import com.au.autogen.model.BalanceTestResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.net.URLEncoder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/test/1.0/tasks/validateBrackets?input=" + URLEncoder.encode("{kk[h()h]kk}", "UTF-8"));
    }

    @Test
    public void shouldValidateBracketsSuccessfully() {
        ResponseEntity<BalanceTestResult> response = template.getForEntity(base.toString(), BalanceTestResult.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
