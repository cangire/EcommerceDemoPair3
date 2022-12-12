package com.etiya.ecommercedemo3.business.dtos.request.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {
    private String title;
    private String description;
    @Positive
    private int customerId;
    @Positive
    private int streetId;
}
