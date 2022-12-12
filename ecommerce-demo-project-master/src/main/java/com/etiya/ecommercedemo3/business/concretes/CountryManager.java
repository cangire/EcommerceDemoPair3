package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CountryService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.country.AddCountryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.country.AddCountryResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Country;
import com.etiya.ecommercedemo3.repository.abstracts.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryManager implements CountryService {
    private CountryRepository countryRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<Country> getById(int id) {
        Country response = countryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Country>(response, Messages.Country.countryGetByIdSuccesMessage);
    }

    @Override
    public DataResult<AddCountryResponse> addCountry(AddCountryRequest addCountryRequest) {
       // checkIfCountryExists(addCountryRequest.get);
//        Country country = new Country();
//        country.setName(addCountryRequest.getName());
        Country country=modelMapperService.getMapperRequest().map(addCountryRequest,Country.class);

        Country savedCountry = countryRepository.save(country);
        AddCountryResponse response=modelMapperService.getMapperResponse().map(savedCountry,AddCountryResponse.class);
//        AddCountryResponse response = new AddCountryResponse(savedCountry.getId(), savedCountry.getName());
        return new SuccessDataResult<AddCountryResponse>(response,Messages.Country.countryAddSuccesMessage);
    }

}
