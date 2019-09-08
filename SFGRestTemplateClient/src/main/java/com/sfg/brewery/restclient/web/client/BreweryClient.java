package com.sfg.brewery.restclient.web.client;

import com.sfg.brewery.restclient.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    @Value("${sfg.config.apiHost}")
    private String apiHost;
    private final String GET_BEER_API_URI_V1 ="/api/v1/beer/";

    private RestTemplate restTemplate;


    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setHostName(String apiHost) {
        this.apiHost = apiHost;
    }



    public BeerDto getBeerById(UUID id)
    {
        return restTemplate.getForObject(this.apiHost +GET_BEER_API_URI_V1 + id,BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto)
    {
        System.out.println(this.apiHost +GET_BEER_API_URI_V1);
    return  restTemplate.postForLocation(this.apiHost +GET_BEER_API_URI_V1, beerDto);

    }

    public void updateBeer(BeerDto beerDto)
    {
         restTemplate.put(this.apiHost +GET_BEER_API_URI_V1 + "/" + beerDto.getId(), beerDto);
    }

    public void deleteBeer(UUID uuid)
    {
        restTemplate.delete(this.apiHost + GET_BEER_API_URI_V1 + "/" + uuid);
    }



}
