package com.capstone.collectionprocesshandling;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.service.DunningService;
@SpringBootTest
public class DunningServiceTest {

    @InjectMocks
    private DunningService dunningService;

    @Mock
    private DunningRepo dunningRepo;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetDunningPays() {
        LocalDate currentDate = LocalDate.now();
        LocalDate thresholdDate = currentDate.minusDays(5);

        // Create a list of DunningEntity objects to simulate the result of dunningPayments
        List<DunningEntity> dunningPayments = new ArrayList<>();
        // Add some test DunningEntity objects to the list

        when(dunningRepo.dunningPayments(thresholdDate)).thenReturn(dunningPayments);

        // Call the method
        List<DunningEntity> result = dunningService.getdunningpays();

        // Perform assertions to verify the result and interactions
        // For example:
        // assertEquals(dunningPayments.size(), result.size());
        // Verify that dunning entries are saved correctly for customers not in dunning
        // Verify the interactions with dunningRepo and customerRepo
    }

    @Test
    public void testDunningPays() {
        // Create a list of DunningEntity objects to simulate the result of dunningpays
        List<DunningEntity> dunningPays = new ArrayList<>();
        // Add some test DunningEntity objects to the list

        when(dunningRepo.findAll()).thenReturn(dunningPays);

        // Call the method
        List<DunningEntity> result = dunningService.dunningpays();

        // Perform assertions to verify the result
        // For example:
        // assertEquals(dunningPays.size(), result.size());
    }

    @Test
    public void testIsCustomerInDunning() {
        // Prepare a test CustomerEntity and a list of DunningEntity objects
        CustomerEntity customer = new CustomerEntity();
        List<DunningEntity> existingDunningEntries = new ArrayList<>();
        // Add some test DunningEntity objects to the list

        when(dunningRepo.findByCustomer(customer)).thenReturn(existingDunningEntries);

        // Call the method
        boolean result = dunningService.isCustomerInDunning(customer);

        // Perform assertions to verify the result
        // For example:
        // assertTrue(result);
    }
}
