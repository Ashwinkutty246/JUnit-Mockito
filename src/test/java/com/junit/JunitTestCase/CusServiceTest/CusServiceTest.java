package com.junit.JunitTestCase.CusServiceTest;

import com.junit.JunitTestCase.model.Customer;
import com.junit.JunitTestCase.repository.CusRepo;
import com.junit.JunitTestCase.service.CusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CusServiceTest {
    @Mock
    private CusRepo cusRepo; // Mock the CusRepo dependency

    @InjectMocks
    private CusService cusService; // Inject mock into CusService

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }
    @Test
    public void testFindAll() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setId(1L);
        customer1.setCusname("Ranjith");
        customer1.setLocation("chennai");

        Customer customer2 = new Customer();
        customer2.setId(2L);
        customer2.setCusname("Jp");
        customer2.setLocation("chennai");
        List<Customer> customerList = Arrays.asList(customer1, customer2);
        when(cusRepo.findAll()).thenReturn(customerList);
        // Act
        List<Customer> result = cusService.findall();
        // Assert
        assertEquals(2, result.size());
        assertEquals("Ranjith", result.get(0).getCusname());
        assertEquals("Jp", result.get(1).getCusname());

    }

    @Test
    void testSaveCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCusname("John Doe");

        when(cusRepo.save(customer)).thenReturn(customer);

        // Act
        Customer savedCustomer = cusService.save(customer);

        // Assert
        assertEquals(customer, savedCustomer, "The saved customer should match the input customer");
        assertNotNull(savedCustomer);
    }
    @Test
    public void TestfindById() {
        Customer cus = new Customer();
        cus.setId(1l);
        cus.setCusname("Ashwin");
        cus.setLocation("chennai");
        when(cusRepo.findById(cus.getId())).thenReturn(Optional.of(cus));

        Optional<Customer> result = cusService.findById(1l);

        assertNotNull(result);
    }
}
