package com.etiya.ecommercedemo3.business.dtos.response.customer;

import com.etiya.ecommercedemo3.entities.concretes.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddCustomerResponse {
    private  int id;
    private int customerNumber;
    private Cart cart;
}
