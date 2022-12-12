package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Country;


public interface CountryService {
    DataResult<Country> getById(int id);
    DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest);
}
