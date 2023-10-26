package com.capstone.collectionprocesshandling;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capstone.collectionprocesshandling.model.CustomerEntity;
import com.capstone.collectionprocesshandling.model.DunningEntity;
import com.capstone.collectionprocesshandling.repository.DunningRepo;
import com.capstone.collectionprocesshandling.service.DunningService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;
@SpringBootTest
class DunningServiceTest {

    @Autowired
    private DunningService dunningService;

    @MockBean
    private DunningRepo dunningRepo;
    @Test
    public void testGetDunningPays() {
        // Sample data
        LocalDate currentDate = LocalDate.now();
        LocalDate thresholdDate = currentDate.minusDays(5);

        DunningEntity dunning1 = new DunningEntity(1, currentDate, new CustomerEntity(1, "Alice", "alice@example.com", "93465922",currentDate,"Tv"));
        DunningEntity dunning2 = new DunningEntity(2, thresholdDate.minusDays(1), new CustomerEntity(2, "Bob", "bob@example.com", "25235142",currentDate,"tv"));
        List<DunningEntity> dunningEntities = new ArrayList<>();
        dunningEntities.add(dunning1);
        dunningEntities.add(dunning2);
    
        // Mock the dunningRepo
        when(dunningRepo.dunningPayments(thresholdDate)).thenReturn(dunningEntities);
        when(dunningRepo.findByCustomer(dunning1.getCustomer())).thenReturn(Collections.singletonList(dunning1));
        when(dunningRepo.findByCustomer(dunning2.getCustomer())).thenReturn(Collections.emptyList());
    
        // Call the method to be tested
        List<DunningEntity> result = dunningService.getdunningpays();
    
        // Verify that the dunningPayments method was called with the expected thresholdDate
        verify(dunningRepo, times(1)).dunningPayments(thresholdDate);
    
        // Verify that the save method was called only for Bob
        verify(dunningRepo, times(1)).save(argThat(dunningEntity -> dunningEntity.getCustomer().getName().equals("Bob")));
    
        // You don't need to verify interactions on DunningService.
    
        // Ensure that the returned list contains only one entry (for Bob)
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getCustomer().getName());
    }
    
    @Test
    public void testIsCustomerInDunning_CustomerInDunning() {
                LocalDate currentDate = LocalDate.now();

        CustomerEntity customer = new CustomerEntity(1, "Alice", "alice@example.com", "93465922",currentDate,"tv");
        DunningEntity dunning = new DunningEntity(1, LocalDate.now(), customer);

        when(dunningRepo.findByCustomer(customer)).thenReturn(Collections.singletonList(dunning));

        boolean isInDunning = dunningService.isCustomerInDunning(customer);

        assertTrue(isInDunning);
    }

    @Test
    public void testIsCustomerInDunning_CustomerNotInDunning() {
                LocalDate currentDate = LocalDate.now();

        CustomerEntity customer = new CustomerEntity(1, "Alice", "alice@example.com", "93465922",currentDate,"tv");

        when(dunningRepo.findByCustomer(customer)).thenReturn(Collections.emptyList());

        boolean isInDunning = dunningService.isCustomerInDunning(customer);

        assertFalse(isInDunning);
    }

    @Test
    public void testDunningPays() {
        // Sample data
                LocalDate currentDate = LocalDate.now();

        DunningEntity dunning1 = new DunningEntity(1, LocalDate.now(), new CustomerEntity(1, "Alice", "alice@example.com", "93465922",currentDate,"tv"));
        DunningEntity dunning2 = new DunningEntity(2, LocalDate.now(), new CustomerEntity(2, "Bob", "bob@example.com", "25235142",currentDate,"tv"));
        List<DunningEntity> dunningEntities = new ArrayList<>();
        dunningEntities.add(dunning1);
        dunningEntities.add(dunning2);

        when(dunningRepo.findAll()).thenReturn(dunningEntities);

        List<DunningEntity> result = dunningService.dunningpays();

        verify(dunningRepo, times(1)).findAll();
        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getCustomer().getName());
        assertEquals("Bob", result.get(1).getCustomer().getName());
    }
}
