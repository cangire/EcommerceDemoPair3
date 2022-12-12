package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.ProductService;
import com.etiya.ecommercedemo3.business.constants.Path;
import com.etiya.ecommercedemo3.business.dtos.request.product.AddProductRequest;
import com.etiya.ecommercedemo3.business.dtos.response.paymentType.AddPaymentTypeResponse;
import com.etiya.ecommercedemo3.business.dtos.response.product.AddProductResponse;
import com.etiya.ecommercedemo3.business.dtos.response.product.GetProductResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Path.apiPrefix + "products")
public class ProductsController {
    @Autowired
    private ProductService productService;


    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll(){
        return productService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<Product> getById(@RequestParam("id") int id){
        return productService.getById(id);
    }

    @GetMapping("/getByStockGreaterThan")
    public DataResult<List<Product>> getAllByStock(@RequestParam("stock") int stock){
        return productService.getAllByStockGreaterThan(stock);
    }

    @GetMapping("/getByName")
    public DataResult<Product> getByName(@RequestParam("name") String name){
        return productService.getByName(name);
    }
    @PostMapping("/add")
    public ResponseEntity<DataResult<AddProductResponse>> add(@RequestBody @Valid AddProductRequest addProductRequest) {
        return new ResponseEntity<>(productService.addProduct(addProductRequest), HttpStatus.CREATED);
    }

    @GetMapping("getProductsByCategory")
    public DataResult<List<GetProductResponse>> getProductsByCategoryId(int identity){
        return productService.getProductsByCategoryId(identity);
    }


}
