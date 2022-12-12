package com.etiya.ecommercedemo3.business.dtos.response.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllPaymentsResponse {
    private int id;
    private String paymentTypeName;
}
