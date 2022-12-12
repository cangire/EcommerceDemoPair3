package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.StreetService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Street;
import com.etiya.ecommercedemo3.repository.abstracts.CityRepository;
import com.etiya.ecommercedemo3.repository.abstracts.StreetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StreetManager implements StreetService {
    private StreetRepository streetRepository;
private CityRepository cityRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<Street> getById(int id) {
       Street response = streetRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Street>(response, Messages.Street.streetGetByIdSuccessMessage);
    }

    @Override
    public DataResult<AddStreetResponse> addStreet(AddStreetRequest addStreetRequest) {
        checkIfCityExists(addStreetRequest.getCityId());
//        Street street = new Street();
//        street.setName(addStreetRequest.getName());
        Street street=modelMapperService.getMapperRequest().map(addStreetRequest,Street.class);
        Street savedStreet = streetRepository.save(street);
        AddStreetResponse response=modelMapperService.getMapperResponse().map(savedStreet,AddStreetResponse.class);
        //AddStreetResponse response = new AddStreetResponse(savedStreet.getId(),savedStreet.getName());
        return new SuccessDataResult<AddStreetResponse>(response,Messages.Street.streetAddSuccessMessage);
    }

    @Override
    public DataResult<List<GetAllStreetsResponse>> getAllDto() {
      List<GetAllStreetsResponse> response= streetRepository.getAllDto();
        return new SuccessDataResult<List<GetAllStreetsResponse>>(response,"Sokak listelendi");
    }
    private void checkIfCityExists(int id){
        boolean isExists = cityRepository.existsById(id);
        if(!isExists) {
            throw new BusinessException(Messages.City.CityNotExistWithId);
        }
    }
}
