package com.rslakra.imageservice;

import com.rslakra.imageservice.domain.Role;
import com.rslakra.imageservice.domain.User;
import com.rslakra.imageservice.payload.UserResponse;
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

/**
 * Author: Rohtash Singh Lakra
 * Created: 2019-03-05 10:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserServiceTests {

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

    @Test
    public void shouldReturn200AfterUserCreation() {
        User newUser = new User("Rohtash", "test", Role.USER);
        final String userUrlString = getUrlForService("/users");
        ResponseEntity<UserResponse> responseEntity = testRestTemplate.postForEntity(userUrlString, newUser, UserResponse.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /**
     * Test for loading all images.
     */
    @Test
    public void shouldReturn200ForAllUser() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrlForService("/users/getAllUsers"), String.class);
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    /**
     * Test for loading all images.
     */
    @Test
    public void shouldReturn404ForUserId1() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(getUrlForService("/users/1"), String.class);
        Assert.assertEquals(HttpStatus.valueOf(404), responseEntity.getStatusCode());
    }

    @Test
    public void contextLoads() {
    }
}
