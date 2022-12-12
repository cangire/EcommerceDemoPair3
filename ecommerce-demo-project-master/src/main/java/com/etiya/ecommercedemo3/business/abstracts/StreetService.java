package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Street;

import java.util.List;

public interface StreetService {
    DataResult<Street> getById(int id);
    DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest);
    DataResult<List<GetAllStreetsResponse>> getAllDto();
}
