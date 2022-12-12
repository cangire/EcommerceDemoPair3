package com.etiya.ecommercedemo3.business.dtos.request.product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductRequest {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
    @Min(1)
    private double unit_price;
    @Min(0)
    private int stock;
}
