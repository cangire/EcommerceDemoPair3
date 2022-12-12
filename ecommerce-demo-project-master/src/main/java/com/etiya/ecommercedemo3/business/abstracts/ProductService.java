package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo3.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo3.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<Product> getById(int id);
    DataResult<List<Product>> getAllByStockGreaterThan(int stock);
    DataResult<Product> getByName(String name);
    DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest);
    DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity);
}
