package com.etiya.ecommercedemo3.business.dtos.request.city;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCityRequest {
    private String name;
    private int countryId;
}
