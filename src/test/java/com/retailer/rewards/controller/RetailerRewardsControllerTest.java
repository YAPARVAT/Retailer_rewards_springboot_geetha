package com.retailer.rewards.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.retailer.rewards.RetailerRewardsApplication;

@SpringBootTest(classes = RetailerRewardsApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class RetailerRewardsControllerTest {

    @LocalServerPort
    private int port;

    @InjectMocks
    private TestRestTemplate restTemplate;

    @Test
    public void givenCustomerName_whenFound_thenReturnRewardPoints() throws Exception {
        String customerName = "customer1";
        
        ResponseEntity<?> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/getCustomerRewardPoints?customerName="+customerName, String.class);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }

    @Test
    public void givenCustomerID_whenNotFound_thenReturnErrorMessage() throws Exception {

        String customerName = "customer10";

        ResponseEntity<?> responseEntity = this.restTemplate
                .getForEntity("http://localhost:" + port + "/getCustomerRewardPoints?customerName="+customerName, String.class);
        assertEquals(400, responseEntity.getStatusCodeValue());
    }
}
