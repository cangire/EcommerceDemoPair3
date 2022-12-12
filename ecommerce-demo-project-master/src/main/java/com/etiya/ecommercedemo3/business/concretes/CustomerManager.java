package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CustomerService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.customer.AddCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.response.customer.AddCustomerResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Customer;
import com.etiya.ecommercedemo3.repository.abstracts.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {
    CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;

//    @Override
//    public AddCustomerResponse addCustomer(AddCustomerRequest addCustomerRequest) {
////        Customer customer =new Customer();
////        customer.setCustomerNumber(addCustomerRequest.getCustomerNumber());
////        customer.setCart(addCustomerRequest.getCart());
//        Customer customer=modelMapperService.getMapperRequest().map(addCustomerRequest,Customer.class);
//
//        Customer savedCustomer=customerRepository.save(customer);
//        AddCustomerResponse response=modelMapperService.getMapperResponse().map(savedCustomer,AddCustomerResponse.class);
////        AddCustomerResponse response=new AddCustomerResponse(savedCustomer.getId(),savedCustomer.getCustomerNumber(),savedCustomer.getCart());
//        return  response;
//    }

    @Override
    public DataResult<Customer> getById(int id) {
        Customer response = customerRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Customer>(response, Messages.Customer.customerGetByIdSuccessMessage);
    }
}
