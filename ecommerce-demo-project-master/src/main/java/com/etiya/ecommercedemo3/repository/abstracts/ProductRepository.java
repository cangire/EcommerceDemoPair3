package com.etiya.ecommercedemo3.repository.abstracts;

import com.etiya.ecommercedemo3.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findAllProductsByStockGreaterThanOrderByStockDesc(int stock);

    @Query("Select new com.etiya.ecommercedemo3.business.dtos.response.product.GetProductResponse(p.name,p.stock,p.unitPrice) from Product  " +
            "as p inner join ProductCategory as pc on p=pc.product inner join Category as c on pc.category=c where c.id in(:identity)" +
            " group by p.name,p.stock,p.unitPrice")
    List<GetProductResponse> getProductByCategoryId(int identity);


    @Query("Select p from Product as p WHERE name=:name")
    Product findByName(String name);
}
