package com.sfg.customer.client;

import com.sfg.customer.client.web.CustomerClient;
import com.sfg.customer.client.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;



    @Test
    void deleteCustomer() {

        this.customerClient.deleteCustomer(UUID.randomUUID());
    }

    @Test
    void createCustomer() {
        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Temp Name").build();
        this.customerClient.createCustomer(customerDto);
    }

    @Test
    void updateCustomer() {

        CustomerDto customerDto = CustomerDto.builder().id(UUID.randomUUID()).name("Temp Name").build();
        this.customerClient.updateCustomer(customerDto);
    }

    @Test
    void getCustomer() {

        UUID customerId = UUID.randomUUID();

        CustomerDto customerDto = this.customerClient.getCustomer(customerId);
        assertNotNull(customerDto);
        System.out.println(customerDto);
    }
}