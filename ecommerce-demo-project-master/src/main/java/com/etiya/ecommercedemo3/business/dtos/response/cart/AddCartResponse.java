package com.etiya.ecommercedemo3.business.dtos.response.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddCartResponse {
    private  int id;
    private double totalPrice;
}
