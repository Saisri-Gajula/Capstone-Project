// package com.capstone.collectionprocesshandling;

// import com.capstone.collectionprocesshandling.model.CustomerEntity;
// import com.capstone.collectionprocesshandling.model.DunningEntity;
// import com.capstone.collectionprocesshandling.repository.CustomerRepo;
// import com.capstone.collectionprocesshandling.repository.DunningRepo;
// import com.capstone.collectionprocesshandling.service.CustomerService;
// import com.capstone.collectionprocesshandling.service.DunningService;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.test.web.server.LocalServerPort;
// import org.springframework.core.ParameterizedTypeReference;
// import org.springframework.http.*;
// import org.springframework.test.context.jdbc.Sql;

// import java.time.LocalDate;
// import java.util.List;
// import java.util.Objects;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.notNull;


// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class IntegrationTesting {

//     @LocalServerPort
//     private int port;

//     @Autowired
//     private TestRestTemplate restTemplate;

//     @Autowired
//     private CustomerRepo customerRepo;

//     @Autowired
//     private CustomerService customerService;

//     @Autowired
//     private DunningRepo dunningRepo;

//     @Autowired
//     private DunningService dunningService;

//     private static HttpHeaders headers;

//     private final ObjectMapper objectMapper = new ObjectMapper();

//     @BeforeAll
//     public static void init() {
//         headers = new HttpHeaders();
//         headers.setContentType(MediaType.APPLICATION_JSON);
//     }

//     @Test
//      public void testCustomerList() {
//         HttpEntity<String> entity = new HttpEntity<>(null, headers);
//         LocalDate currentDate = LocalDate.now();

//         CustomerEntity customer1 = new CustomerEntity(1,"priya","priya@gmail.com","+91973458124",currentDate,"tv");
//         customerRepo.save(customer1);
//         CustomerEntity customer2 = new CustomerEntity(2, "emo", "emo@gmail.com", "+919704937049",currentDate,"tv");
//         customerRepo.save(customer2);

//         ResponseEntity<List<CustomerEntity>> response = restTemplate.exchange(
//                 createURLWithPort("/api/customers"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<CustomerEntity>>(){});
//         List<CustomerEntity> customerList = response.getBody();
//         assert customerList != null;
//         assertEquals(response.getStatusCode().value(), 200);
//         assertEquals(customerList.size(), customerService.getAllCustomers().size());
//         assertEquals(customerList.size(), customerRepo.findAll().size());
//     }

    
//     @Test
//     // @Sql(statements = "DELETE FROM orders WHERE id='3'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//     public void testCreateCustomer() throws JsonProcessingException {
//         LocalDate currentDate = LocalDate.now();

//         CustomerEntity customer = new CustomerEntity(3, "priya", "priya@gmail.com", "+918567474899",currentDate,"tv");
//         HttpEntity<String> entity = new HttpEntity<>(objectMapper.writeValueAsString(customer), headers);
//         ResponseEntity<CustomerEntity> response = restTemplate.exchange(
//                 createURLWithPort("/api/add-customer"), HttpMethod.POST, entity, CustomerEntity.class);
//         assertEquals(response.getStatusCode().value(), 200);
//         CustomerEntity customerRes = Objects.requireNonNull(response.getBody());
//         assertEquals(customerRes.getName(), "priya");
//         assertEquals(customerRes.getName(), customerRepo.save(customer).getName());
//     }
    
    
//     @Test
//     // @Sql(statements = "INSERT INTO orders(id, buyer, price, qty) VALUES (6, 'alex', 75.0, 3)", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//     // @Sql(statements = "DELETE FROM orders WHERE id='6'", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
//     public void testDeleteCustomer() {        LocalDate currentDate = LocalDate.now();

//          CustomerEntity customer1 = new CustomerEntity(6,"priya","priya@gmail.com","+91973458124",currentDate,"tv");
//         customerRepo.save(customer1);
//         ResponseEntity<String> response = restTemplate.exchange(
//                 (createURLWithPort("/api/6")), HttpMethod.DELETE, null, String.class);
//         String customerRes = response.getBody();
//         System.out.println(customerRes);
//         assertEquals(response.getStatusCode().value(), 204);
//         // assertNotNull(customerRes,"");
//         assertEquals(customerRes, notNull());
//     }

//     @Test
//      public void testDunningPaysList() {
//         HttpEntity<String> entity = new HttpEntity<>(null, headers);
//         LocalDate dueDate = LocalDate.now();
//         DunningEntity dunningpay1 = new DunningEntity(1,dueDate,1);
//         dunningRepo.save(dunningpay1);
//          DunningEntity dunningpay2 = new DunningEntity(2,dueDate,2);
//         dunningRepo.save(dunningpay2);

//         ResponseEntity<List<DunningEntity>> response = restTemplate.exchange(
//                 createURLWithPort("/api/dunningPays"), HttpMethod.GET, entity, new ParameterizedTypeReference<List<DunningEntity>>(){});
//         List<DunningEntity> dunningList = response.getBody();
//         assert dunningList != null;
//         assertEquals(response.getStatusCode().value(), 200);
//         assertEquals(dunningList.size(), dunningService.dunningpays().size());
//         assertEquals(dunningList.size(), dunningRepo.findAll().size());
//     }

    
//     private String createURLWithPort(String path) {
//         return "http://localhost:" + port + path;
//     }

// }