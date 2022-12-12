package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.response.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;

import java.util.List;

public interface PaymentService {
    DataResult<List<GetAllPaymentsResponse>> getAllDto();
}
