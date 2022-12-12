package com.etiya.ecommercedemo3.business.dtos.response.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderResponse {
    private int Id;
    private int paymentId;
    private int customerId;
}
