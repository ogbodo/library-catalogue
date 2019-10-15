package com.paga.librarycatalogue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryCatalogueApplicationTests {

	@Test
	public void contextLoads() {
	}

	/**
	 * Lets test that we can add catalogue
	 */
	@Test
	public void testAddCatalogue() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);

		// ResponseEntity<String> response = new RestTemplate().exchange(getRoot);
	}

}
