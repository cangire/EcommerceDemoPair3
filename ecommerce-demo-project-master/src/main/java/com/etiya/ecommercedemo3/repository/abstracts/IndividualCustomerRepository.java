package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.IndividualCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IndividualCustomerRepository extends JpaRepository<IndividualCustomer, Integer> {
    @Query("Select inn from IndividualCustomer as inn where nationalIdentity=:nationalIdentity")
    IndividualCustomer findIndividualCustomerBynationalIdentity(String nationalIdentity);

    List<IndividualCustomer> findIndividualCustomerByFirstName(String firstName);
}
