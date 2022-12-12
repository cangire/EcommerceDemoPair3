package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
