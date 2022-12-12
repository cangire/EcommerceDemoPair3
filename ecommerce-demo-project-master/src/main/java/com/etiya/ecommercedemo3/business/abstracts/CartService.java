package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cart.AddCartResponse;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;

public interface CartService {
    DataResult<AddCartResponse> addCart(AddCartRequest addCartRequest);
}
