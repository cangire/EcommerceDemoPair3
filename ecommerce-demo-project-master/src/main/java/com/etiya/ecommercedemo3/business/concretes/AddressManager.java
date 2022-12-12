package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.*;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo3.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.*;
import com.etiya.ecommercedemo3.repository.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private CityRepository cityRepository;

    private CountryRepository countryRepository;

    private StreetRepository streetRepository;

    private CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;


    @Override
    public DataResult<List<Address>> getAll() {
        List<Address> response = addressRepository.findAll();
        return new SuccessDataResult<List<Address>>(response,Messages.Address.addressListAllSuccessMessage);
    }

    @Override
    public DataResult<Address> getById(int id) {
        Address response = addressRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Address>(response,Messages.Address.addressGetByIdSuccessMessage);
    }

    @Override
    public List<Address> getAllAddressByTitle(String title) {
        return addressRepository.findAllAddressByTitle(title);
    }

    @Override
    public Address findByDescription(String description) {
        return addressRepository.findByDescription(description);
    }

    @Override
    public DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest) {
//        Address address = new Address();
//        address.setTitle(addAddressRequest.getTitle());
//        address.setDescription(addAddressRequest.getDescription());
//
//        City city = cityService.getById(addAddressRequest.getCityId());
//        address.setCity(city);
//
//        Country country = countryService.getById(addAddressRequest.getCountryId());
//        address.setCountry(country);
        checkIfStreetExists(addAddressRequest.getStreetId());
//        Street street = streetService.getById(addAddressRequest.getStreetId());
//        address.setStreet(street);
        checkIfCustomerExists(addAddressRequest.getCustomerId());
//        Customer customer = customerService.getById(addAddressRequest.getCustomerId());
//        address.setCustomer(customer);

        Address address= modelMapperService.getMapperRequest().map(addAddressRequest,Address.class);


        Address savedAddress = addressRepository.save(address);
        AddAddressResponse response= modelMapperService.getMapperResponse().map(savedAddress,AddAddressResponse.class);
//        AddAddressResponse response = new AddAddressResponse(savedAddress.getId(), savedAddress.getTitle(), savedAddress.getDescription(), savedAddress.getCity().getId(),savedAddress.getCountry().getId(),savedAddress.getStreet().getId(),savedAddress.getCustomer().getId());
        return new SuccessDataResult<AddAddressResponse>(response,Messages.Address.addressAddingSuccessMessage);
    }

    private void checkIfStreetExists(int id){
        boolean isExists = streetRepository.existsById(id);
        if(!isExists) {
            //business exception
            throw new BusinessException(Messages.Street.StreetNotExistWithId);
        }
    }

    private void checkIfCustomerExists(int id){
        boolean isExists = customerRepository.existsById(id);
        if(!isExists) {
            //business exception
            throw new BusinessException(Messages.Customer.CustomerNotExistWithId);
        }
    }


}
