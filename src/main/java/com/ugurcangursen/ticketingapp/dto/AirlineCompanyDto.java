package com.ugurcangursen.ticketingapp.dto;

import io.swagger.annotations.ApiModelProperty;


public class AirlineCompanyDto {

    @ApiModelProperty(required = true, value = "ID")
    private Long id;
    @ApiModelProperty(required = true, value = "Airline Name")
    private String name;

    public AirlineCompanyDto() {
    }

    public AirlineCompanyDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
