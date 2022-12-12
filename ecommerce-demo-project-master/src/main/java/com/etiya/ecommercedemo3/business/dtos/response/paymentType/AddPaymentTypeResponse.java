package com.etiya.ecommercedemo3.business.dtos.response.paymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddPaymentTypeResponse {
    private  int Id;
    private String name;
    private String description;
}
