package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.entities.concretes.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street, Integer> {
    @Query("select new com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse" +
            "(s.id,s.name,ci.name) from Street s inner join s.city ci")
    List<GetAllStreetsResponse> getAllDto();
    boolean existsById(int id);
}
