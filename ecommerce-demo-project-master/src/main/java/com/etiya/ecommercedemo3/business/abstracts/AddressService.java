package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.address.AddAddressRequest;
import com.etiya.ecommercedemo3.business.dtos.request.cart.AddCartRequest;
import com.etiya.ecommercedemo3.business.dtos.response.address.AddAddressResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.Result;
import com.etiya.ecommercedemo3.entities.concretes.Address;

import java.util.List;

public interface AddressService {
    DataResult<List<Address>> getAll();
     DataResult<Address> getById(int id);
     List<Address> getAllAddressByTitle(String title);
    Address findByDescription(String description);
    DataResult<AddAddressResponse> addAddress(AddAddressRequest addAddressRequest);
}
