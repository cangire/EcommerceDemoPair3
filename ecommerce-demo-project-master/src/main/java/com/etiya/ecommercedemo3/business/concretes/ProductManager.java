package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.ProductService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo3.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo3.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import com.etiya.ecommercedemo3.repository.abstracts.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Product>> getAll() {
        List<Product> response =productRepository.findAll();
        return new SuccessDataResult<List<Product>>(response, Messages.Product.productAddSuccesMessage);
    }

    @Override
    public DataResult<Product> getById(int id) {
        Product response = productRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Product>(response,Messages.Product.productGetByIdSuccesMessage) ;
    }

    @Override
    public DataResult<List<Product>> getAllByStockGreaterThan(int stock) {
        List<Product> response =productRepository.findAllProductsByStockGreaterThanOrderByStockDesc(stock);
        return new SuccessDataResult<List<Product>>(response,Messages.Product.productAllByStockGreaterThanSuccesMessage) ;
    }

    @Override
    public DataResult<Product> getByName(String name) {
        Product response = productRepository.findByName(name);
        return new SuccessDataResult<Product>(response,Messages.Product.productGetByNameSuccesMessage) ;
    }

    @Override
    public DataResult<AddProductResponse> addProduct(AddProductRequest addProductRequest) {
//        Product product = new Product();
//        product.setName(addProductRequest.getName());
//        product.setStock(addProductRequest.getStock());
//        product.setUnit_price(addProductRequest.getUnit_price());
        Product product=modelMapperService.getMapperRequest().map(addProductRequest,Product.class);
        Product savedProduct = productRepository.save(product);
        AddProductResponse response=modelMapperService.getMapperResponse().map(savedProduct,AddProductResponse.class);
       // AddProductResponse response = new AddProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getUnit_price(), savedProduct.getStock());
        return new SuccessDataResult<AddProductResponse>(response,Messages.Product.productAddSuccesMessage);
    }

    @Override
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity) {
        List<GetProductResponse> response = productRepository.getProductByCategoryId(identity);
        return new SuccessDataResult<List<GetProductResponse>>(response, "Kategori ıd getirildi");
    }

}
