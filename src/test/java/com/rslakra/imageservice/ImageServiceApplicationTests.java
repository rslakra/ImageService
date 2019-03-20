/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.rslakra.imageservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ImageServiceApplicationTests {

	private final String TEMP_FOLDER = "/Users/lakra/Downloads/Temp";

	@LocalServerPort
	private int port;

	@Autowired
	TestRestTemplate testRestTemplate;

	@Autowired
	WebApplicationContext webApplicationContext;

	/**
	 * @return
	 */
	private final String getUrlForService(String serviceName) {
		return "http://localhost:" + port + (serviceName.startsWith("/") ? serviceName : "/" + serviceName);
	}

	/**
	 * Test for loading all images.
	 */
	@Test
	public void shouldReturn200ForLoadAllImages() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrlForService("loadAllImages"),
				String.class);
		Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	/**
	 * Test for loading all images.
	 */
	@Test
	public void shouldReturn404ForDownloadImageId1() {
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrlForService("download/1"),
				String.class);
		Assert.assertEquals(HttpStatus.valueOf(404), responseEntity.getStatusCode());
	}

	@Test
	public void contextLoads() {
	}

}
