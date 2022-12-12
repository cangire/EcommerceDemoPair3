package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    DataResult<List<PaymentType>> getAll();
    DataResult<PaymentType> getById(int id);
    DataResult<PaymentType> getByName(String name);
    DataResult<PaymentType> getByDescription(String description);
    DataResult<AddPaymentTypeResponse> addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest);
}
