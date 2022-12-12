package com.etiya.ecommercedemo3.business.dtos.response.street;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllStreetsResponse {
    private int id;
    private String name;
    private String cityName;
}
