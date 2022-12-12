package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.PaymentTypeService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.paymentType.AddPaymentTypeRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.PaymentType;
import com.etiya.ecommercedemo3.repository.abstracts.PaymentTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PaymentTypeManager implements PaymentTypeService {
    private PaymentTypeRepository paymentTypeRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<PaymentType>> getAll() {
        List<PaymentType> response = paymentTypeRepository.findAll();
        return new SuccessDataResult<List<PaymentType>>(response, Messages.PaymentType.paymentTypeGetAllSuccessMessage);
    }

    @Override
    public DataResult<PaymentType> getById(int id) {
        PaymentType response = paymentTypeRepository.findById(id).orElseThrow();
        return new  SuccessDataResult<PaymentType>(response,Messages.PaymentType.paymentTypeGetByIdSuccessMessage);
    }

    @Override
    public DataResult<PaymentType> getByName(String name) {
        PaymentType response =  paymentTypeRepository.findByName(name);
        return  new  SuccessDataResult<PaymentType>(response,Messages.PaymentType.paymentTypeGetByNameSuccessMessage)  ;
    }

    @Override
    public DataResult<PaymentType> getByDescription(String description) {
        PaymentType response =  paymentTypeRepository.findPaymentTypeByDescription(description);
        return new SuccessDataResult<PaymentType>(response,Messages.PaymentType.paymentTypeGetByDescriptionSuccessMessage) ;
    }

    @Override
    public DataResult<AddPaymentTypeResponse> addPaymentType(AddPaymentTypeRequest addPaymentTypeRequest) {
//        PaymentType paymentType=new PaymentType();
//        paymentType.setDescription(addPaymentTypeRequest.getDescription());
//        paymentType.setName(addPaymentTypeRequest.getName());
        PaymentType paymentType=modelMapperService.getMapperRequest().map(addPaymentTypeRequest,PaymentType.class);

        PaymentType savedPaymentType=paymentTypeRepository.save(paymentType);

        AddPaymentTypeResponse response=modelMapperService.getMapperResponse().map(savedPaymentType,AddPaymentTypeResponse.class);
//        AddPaymentTypeResponse response=new AddPaymentTypeResponse(savedPaymentType.getId(),savedPaymentType.getDescription(),savedPaymentType.getName());
        return  new SuccessDataResult<AddPaymentTypeResponse>(response,Messages.PaymentType.paymentTypeAddSuccessMessage);
    }
}
