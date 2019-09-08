package com.sfg.brewery.restclient.web.client;

import com.sfg.brewery.restclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;



    @Test
    void getBeerById() {

        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void testSaveBeer()
    {
        BeerDto beerDto = BeerDto.builder().beerName("TestBeer")
                .id(UUID.randomUUID()).upc(Math.round(Math.random()*1000000)).beerStyleEnum("IPA").build();

        URI beerURI= client.saveBeer(beerDto);
        assertNotNull(beerURI);
        System.out.println("URI:: " + beerURI);

    }

    @Test
    void upateSaveBeer()
    {
        BeerDto beerDto = BeerDto.builder().beerName("TestBeer")
                .id(UUID.randomUUID()).upc(Math.round(Math.random()*1000000)).beerStyleEnum("IPA").build();

        client.updateBeer(beerDto);

    }

    @Test
    void deleteBeer()
    {
        client.deleteBeer(UUID.randomUUID());
    }
}