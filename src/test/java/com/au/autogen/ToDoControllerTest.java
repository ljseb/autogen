package com.au.autogen;

import com.au.autogen.model.ToDoItem;
import com.au.autogen.model.ToDoItemAddRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ToDoControllerTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    RestTemplate restTemplate = new RestTemplate();

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/test/1.0/todo");
    }

    @Test
    public void shouldGetTodoItemForId() {
        ResponseEntity<ToDoItem> response = template.getForEntity(base.toString() + "/1",
                ToDoItem.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
        assertThat(response.getBody().getText(), equalTo("Some text ideally from DB1"));
    }

    @Test
    public void shouldCreateTodoItemForId() throws URISyntaxException {

        URI uri = new URI(base.toString());
        ToDoItemAddRequest req = new ToDoItemAddRequest();
        req.setText("Adam");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ToDoItemAddRequest> request = new HttpEntity<>(req, headers);
        ResponseEntity<ToDoItem> result = restTemplate.postForEntity(uri, request, ToDoItem.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().getText().equals("Adam"));
    }

   /* @Test
    public void shouldUpdateTodoItemForId() throws URISyntaxException {

        URI uri = new URI(base.toString()+"/1");
        ToDoItemUpdateRequest req = new ToDoItemUpdateRequest();
        req.setText("Adam");
        req.setIsCompleted(true);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ToDoItemUpdateRequest> request = new HttpEntity<>(req, headers);
        ToDoItem result = restTemplate.patchForObject(uri, request, ToDoItem.class);
        Assert.assertEquals(true, result.getText().contains("Adam"));
    }*/


}
