package com.etiya.ecommercedemo3.business.dtos.response.IndividualCustomer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddIndividualCustomerResponse {

    private int Id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;


}
