package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.IndividualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo3.business.dtos.response.IndividualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;

public interface OrderService {
    DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest);
}
