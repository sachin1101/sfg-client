package com.swagger.example.carInventory.web.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.sql.DataSourceDefinition;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    @ApiModelProperty(notes = "Name of the Car",name="name",required=true,value="car")
    private  String name;

}
