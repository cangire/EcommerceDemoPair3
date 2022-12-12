package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CityService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.City;
import com.etiya.ecommercedemo3.repository.abstracts.CityRepository;
import com.etiya.ecommercedemo3.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityManager implements CityService {
    private CityRepository cityRepository;
private CountryRepository countryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<City> getById(int id) {
        City response=  cityRepository.findById(id).orElseThrow();
        return new SuccessDataResult<City>(response, Messages.City.CityGetById) ;
    }

    @Override
    public DataResult<AddCityResponse> addCity(AddCityRequest addCityRequest) {
//        City city = new City();
//        city.setName(addCityRequest.getName());
        checkIfCountryExists(addCityRequest.getCountryId());
        City city= modelMapperService.getMapperRequest().map(addCityRequest,City.class);
        City savedCity = cityRepository.save(city);
        AddCityResponse response=modelMapperService.getMapperResponse().map(savedCity,AddCityResponse.class);
//        AddCityResponse response = new AddCityResponse(savedCity.getId(), savedCity.getName());
        return new SuccessDataResult<AddCityResponse>(response,Messages.City.CityAddSuccessMessage);
    }
    private void checkIfCountryExists(int id){
        boolean isExists = countryRepository.existsById(id);
        if(!isExists) {
            //business exception
            throw new BusinessException(Messages.Country.CountryNotExistWithId);
        }
    }
}
