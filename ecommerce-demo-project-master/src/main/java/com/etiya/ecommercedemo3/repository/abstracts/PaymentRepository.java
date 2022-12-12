package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.business.dtos.response.payment.GetAllPaymentsResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.entities.concretes.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    @Query("select new com.etiya.ecommercedemo3.business.dtos.response.payment.GetAllPaymentsResponse" +
            "(p.id,py.name) from Payment p inner join p.paymentType py")
    List<GetAllPaymentsResponse> getAllDto();
}
