package com.thiagocardoso.issuetracker;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IssueTrackerApplicationTests {

	@Autowired
    WebTestClient client;

	@Test
	public void contextLoads() {
	}

	@Test
    public void getSimpleRoute() {
	    client
                .get()
                .uri("/test")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus()
                .isOk();
    }

	@Test
	public void getTestController() {
		client
				.get()
				.uri("/testcontroller/")
				.accept(MediaType.TEXT_PLAIN)
				.exchange()
				.expectStatus()
				.isOk();
	}

}
