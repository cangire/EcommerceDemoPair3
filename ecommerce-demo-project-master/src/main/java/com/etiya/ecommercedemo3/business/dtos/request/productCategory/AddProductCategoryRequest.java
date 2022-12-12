package com.etiya.ecommercedemo3.business.dtos.request.productCategory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AddProductCategoryRequest {
    @Positive
    private int categoryId;
    @Positive
    private int productId;
}
