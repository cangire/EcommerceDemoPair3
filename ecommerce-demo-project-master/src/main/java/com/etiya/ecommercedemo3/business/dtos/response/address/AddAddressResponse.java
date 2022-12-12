package com.etiya.ecommercedemo3.business.dtos.response.address;

import com.etiya.ecommercedemo3.entities.concretes.City;
import com.etiya.ecommercedemo3.entities.concretes.Country;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.entities.concretes.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressResponse {
    private int id;
    private String title;
    private String description;
    private int customerId;
    private int streetId;
}
