package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.entities.concretes.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentTypeRepository extends JpaRepository<PaymentType,Integer> {

    @Query("Select pt from PaymentType as pt where name=:name")
    PaymentType findByName(String name);

    PaymentType findPaymentTypeByDescription(String description);
}
