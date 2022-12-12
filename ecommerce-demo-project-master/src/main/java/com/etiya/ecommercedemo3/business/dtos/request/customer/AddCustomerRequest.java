package com.etiya.ecommercedemo3.business.dtos.request.customer;

import com.etiya.ecommercedemo3.entities.concretes.Cart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddCustomerRequest {
    private int customerNumber;
    private int cartId;
}
