package com.etiya.ecommercedemo3.business.dtos.response.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCityResponse {
    private int id;
    private String name;
    private int countryId;
}
