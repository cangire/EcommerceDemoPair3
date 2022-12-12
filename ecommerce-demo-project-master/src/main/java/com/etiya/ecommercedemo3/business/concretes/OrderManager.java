package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.OrderService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.order.AddOrderRequest;
import com.etiya.ecommercedemo3.business.dtos.response.IndividualCustomer.AddIndividualCustomerResponse;
import com.etiya.ecommercedemo3.business.dtos.response.order.AddOrderResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import com.etiya.ecommercedemo3.entities.concretes.Order;
import com.etiya.ecommercedemo3.entities.concretes.Payment;
import com.etiya.ecommercedemo3.repository.abstracts.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderManager implements OrderService {
   private OrderRepository orderRepository;
private ModelMapperService modelMapperService;
    @Override
    public DataResult<AddOrderResponse> addOrder(AddOrderRequest addOrderRequest) {
        Order order=modelMapperService.getMapperRequest().map(addOrderRequest, Order.class);

        Order savedOrder = orderRepository.save(order);

        AddOrderResponse response=modelMapperService.getMapperResponse().map(savedOrder,AddOrderResponse.class);


        return new SuccessDataResult<AddOrderResponse>(response, Messages.Order.orderAddSuccessMessage);

    }
}
