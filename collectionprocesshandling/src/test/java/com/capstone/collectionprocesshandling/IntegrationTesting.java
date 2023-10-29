package com.capstone.collectionprocesshandling;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.CustomerRepo;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.service.CustomerService;
import com.capstone.collectionprocesshandling.service.DunningService;

import org.junit.jupiter.api.Test;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class IntegrationTesting {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private DunningRepo dunningRepo;

    @Autowired
    private DunningService dunningService;

    @Autowired
    private CustomerService customerService;

    private static HttpHeaders headers;

    @BeforeEach
    public void setup() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    public void testGetCustomers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/customers"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddCustomer() {
        CustomerEntity customer = new CustomerEntity();
        customer.setName("Test Customer");
        customer.setMailId("test@example.com");
        customer.setAmount(1000);

        HttpEntity<CustomerEntity> entity = new HttpEntity<>(customer, headers);

        ResponseEntity<CustomerEntity> response = restTemplate.postForEntity("/api/add-customer", entity, CustomerEntity.class);
        assertThat(response.getStatusCodeValue()).isEqualTo(200);

        CustomerEntity addedCustomer = response.getBody();
        assertNotNull(addedCustomer);
        assertEquals("Test Customer", addedCustomer.getName());

        // You can add more assertions here to validate the added customer's data.
    }


    @Test
    public void testGetDunningPays() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/dunningPays"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetDunningPaysData() {
        // Assuming that your dunning service returns a list of DunningEntity
        List<DunningEntity> dunningList = dunningService.dunningpays();
        assertNotNull(dunningList);

        // Send a GET request to retrieve dunning pays from the API
        ResponseEntity<List> responseEntity = restTemplate.getForEntity("/api/dunningPays", List.class);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);

        // Check that the data retrieved from the API matches the data from the service
        List<DunningEntity> apiDunningList = responseEntity.getBody();
        assertNotNull(apiDunningList);

        // Assuming that the comparison of dunning lists is based on size
        assertEquals(dunningList.size(), apiDunningList.size());
    }
    
}
