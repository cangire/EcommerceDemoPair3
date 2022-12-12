package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.OrderService;
import com.etiya.ecommercedemo3.business.constants.Path;
import com.etiya.ecommercedemo3.business.dtos.request.IndividualCustomer.AddIndividualCustomerRequest;
import com.etiya.ecommercedemo3.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo3.business.dtos.response.IndividualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Path.apiPrefix + "orders")
@AllArgsConstructor
public class OrdersController {
    private OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddOrderRequest>> add(@RequestBody AddOrderRequest addOrderRequest) {
        return new ResponseEntity(orderService.addOrder(addOrderRequest), HttpStatus.CREATED);
    }
}
