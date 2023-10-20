// package com.capstone.collectionprocesshandling;

// import org.junit.jupiter.api.Test;

// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

// import com.capstone.collectionprocesshandling.Model.CustomerEntity;
// import com.capstone.collectionprocesshandling.Model.dunningEntity;
// import com.capstone.collectionprocesshandling.Model.paymentReceipt;
// import com.capstone.collectionprocesshandling.Repository.dunningRepo;
// import com.capstone.collectionprocesshandling.service.dunningService;

// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.mockito.Mockito.*;

// @SpringBootTest
// class DunningServiceTest {

//     @Autowired
//     private dunningService dunningService;

//     @MockBean
//     private dunningRepo dunningRepo;

//     // @Test
//     // public void testGetDunningPays_Success() {
//     //     LocalDate currentDate = LocalDate.now();
//     //     LocalDate thresholdDate = currentDate.minusDays(5);
//     //     paymentReceipt payment1 = new paymentReceipt(1, 5000, currentDate.minusDays(3), new CustomerEntity(1, "Alice", "alice@example.com", "24245252", currentDate.minusDays(3)));
//     //     paymentReceipt payment2 = new paymentReceipt(2, 3000, currentDate.minusDays(4), new CustomerEntity(2, "Bob", "bob@example.com", "435262542", currentDate.minusDays(4)));
//     //     List<paymentReceipt> dunningPayments = new ArrayList<>();
//     //     dunningPayments.add(payment1);
//     //     dunningPayments.add(payment2);

//     //     when(dunningRepo.dunningPayments(thresholdDate)).thenReturn(dunningPayments);
//     //     when(dunningRepo.findByCustomer(payment1.getCustomer())).thenReturn(new ArrayList<>());
//     //     when(dunningRepo.findByCustomer(payment2.getCustomer())).thenReturn(new ArrayList<>());

//     //     List<paymentReceipt> result = dunningService.getdunningpays();

//     //     verify(dunningRepo, times(1)).dunningPayments(thresholdDate);
//     //     verify(dunningRepo, times(1)).save(any(dunningEntity.class));

//     //     assertEquals(2, result.size());
//     //     assertEquals("Alice", result.get(0).getCustomer().getName());
//     //     assertEquals("Bob", result.get(1).getCustomer().getName());
//     // }

//     @Test
//     public void testDunningPays_Success() {
//         // Sample data
//         LocalDate date = LocalDate.now();
//         dunningEntity dunning1 = new dunningEntity(1, LocalDate.now(), new CustomerEntity(1, "Alice", "alice@example.com", "93465922", date));
//         dunningEntity dunning2 = new dunningEntity(2, LocalDate.now(), new CustomerEntity(2, "Bob", "bob@example.com", "25235142", date));
//         List<dunningEntity> dunningEntities = new ArrayList<>();
//         dunningEntities.add(dunning1);
//         dunningEntities.add(dunning2);
//         when(dunningRepo.findAll()).thenReturn(dunningEntities);

//         List<dunningEntity> result = dunningService.dunningpays();
//         verify(dunningRepo, times(1)).findAll();
//         assertEquals(2, result.size());
//         assertEquals("Alice", result.get(0).getCustomer().getName());
//         assertEquals("Bob", result.get(1).getCustomer().getName());
//     }
// }
