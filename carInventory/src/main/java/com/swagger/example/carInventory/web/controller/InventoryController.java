package com.swagger.example.carInventory.web.controller;

import com.swagger.example.carInventory.service.CarInventoryService;
import com.swagger.example.carInventory.web.model.CarDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "InventoryController" ,  tags =("REST APIs related to Car Inventory"))
@RestController("/car")
public class InventoryController {

    CarInventoryService carInventoryService;

    @Autowired
    public InventoryController(CarInventoryService carInventoryService) {
        this.carInventoryService = carInventoryService;
    }




    @ApiOperation(value ="Get List of the cars", response = Iterable.class, tags =  "getCars")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @GetMapping("/api/v1/inventory")
    public ResponseEntity<List<CarDto>> getCars()
    {
        return new ResponseEntity(carInventoryService.getCarList(), HttpStatus.OK);
    }
}
