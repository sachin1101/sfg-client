package com.sfg.customer.client.web;

import com.sfg.customer.client.web.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    private RestTemplate restTemplate;

    private String API_BASE_PATH ="/customer/api/v1";

    @Value("${api.hostName}")
    private String apiHostName;

    @Autowired
    public CustomerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void deleteCustomer(UUID customerId){
        this.restTemplate.delete(this.apiHostName +API_BASE_PATH +"/" + customerId);
    }

    public void createCustomer(CustomerDto customerDto)
    {
        this.restTemplate.put(this.apiHostName +API_BASE_PATH , customerDto);

    }

    public URI updateCustomer(CustomerDto customerDto)
    {
      return    this.restTemplate.postForLocation(apiHostName + "/" + API_BASE_PATH + "/" + customerDto.getId(), customerDto);

    }

    public CustomerDto getCustomer(UUID customerId)
    {
        ResponseEntity<CustomerDto> getCustomerResponse = this.restTemplate.getForEntity(apiHostName + "/" + API_BASE_PATH + "/get/" + customerId, CustomerDto.class);
        return getCustomerResponse.getBody();
    }
}
