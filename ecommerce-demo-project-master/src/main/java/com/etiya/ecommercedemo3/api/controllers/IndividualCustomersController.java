package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.IndividualCustomerService;
import com.etiya.ecommercedemo3.business.constants.Path;
import com.etiya.ecommercedemo3.business.dtos.request.IndividualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.response.IndividualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(Path.apiPrefix + "individualCustomers")
@AllArgsConstructor
public class IndividualCustomersController {
    IndividualCustomerService individualCustomerService;

    @GetMapping("/getAll")
    public DataResult<List<IndividualCustomer>> getAll(){
        return individualCustomerService.getAll();
    }

    @GetMapping("{id}")
    public DataResult<IndividualCustomer> getById(@PathVariable int id){
        return individualCustomerService.getById(id);
    }

    @GetMapping("/firstName")
    public DataResult<List<IndividualCustomer>> getIndividualCustomerByFirstName(@RequestParam("firstName") String firstName){
        return individualCustomerService.getIndividualCustomerByFirstName(firstName);
    }

    @GetMapping("/nationalIdentity")
    public DataResult<IndividualCustomer> getIndividualCustomerBynationalIdentity(@RequestParam("nationalIdentity") String nationalIdentity){
        return individualCustomerService.getIndividualCustomerBynationalIdentity(nationalIdentity);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddIndividualCustomerResponse>> add(@RequestBody AddIndividualCustomerRequest addAIndividualRequest) {
        return new ResponseEntity<>(individualCustomerService.addIndividualCustomer(addAIndividualRequest), HttpStatus.CREATED);
    }
}
