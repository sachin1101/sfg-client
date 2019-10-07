package com.swagger.example.carInventory.service;

import com.swagger.example.carInventory.web.model.CarDto;

import java.util.List;

public interface CarInventoryService {
    List<CarDto> getCarList();
}
