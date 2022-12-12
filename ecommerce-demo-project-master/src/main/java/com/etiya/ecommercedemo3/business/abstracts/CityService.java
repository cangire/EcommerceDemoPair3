package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.City;

import java.util.List;

public interface CityService {
    DataResult<City> getById(int id);
    DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest);


}
