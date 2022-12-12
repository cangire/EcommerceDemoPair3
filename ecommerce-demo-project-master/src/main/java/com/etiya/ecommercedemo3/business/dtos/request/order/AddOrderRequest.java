package com.etiya.ecommercedemo3.business.dtos.request.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddOrderRequest {
    private int paymentId;
    private int customerId;
}
