package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    //List<Category> findByNameEquals(String name);
    boolean existsCategoryByName(String name);
    boolean existsById(int id);




}
