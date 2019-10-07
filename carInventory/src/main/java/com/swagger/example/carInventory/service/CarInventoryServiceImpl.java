package com.swagger.example.carInventory.service;

import com.swagger.example.carInventory.web.model.CarDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarInventoryServiceImpl implements  CarInventoryService {

    private List<CarDto> carList ;

    @Override
    public List<CarDto> getCarList() {
        return this.carList;
    }

    @PostConstruct
    private void loadCarList()
    {
        this.carList = new ArrayList<>();

        this.carList.add( CarDto.builder().name("Corolla").build());
        this.carList.add( CarDto.builder().name("Civic").build());
        this.carList.add( CarDto.builder().name("Sonata").build());
        this.carList.add( CarDto.builder().name("Accord").build());
    }
}
