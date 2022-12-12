package com.etiya.ecommercedemo3.business.dtos.request.paymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddPaymentTypeRequest {
    private String name;
    private String description;
}
