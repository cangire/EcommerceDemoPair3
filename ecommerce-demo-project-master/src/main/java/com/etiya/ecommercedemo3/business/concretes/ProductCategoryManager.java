package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.abstracts.ProductCategoryService;
import com.etiya.ecommercedemo3.business.abstracts.ProductService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.productCategory.AddProductCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.productCategory.AddProductCategoryResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.ProductCategory;
import com.etiya.ecommercedemo3.repository.abstracts.CategoryRepository;
import com.etiya.ecommercedemo3.repository.abstracts.ProductCategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductCategoryManager implements ProductCategoryService {
    private ProductCategoryRepository productCategoryRepository;
    private CategoryService categoryService;
    private ProductService productService;
    private final CategoryRepository categoryRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<AddProductCategoryResponse> addProductCategory(AddProductCategoryRequest addProductCategoryRequest) {
//        ProductCategory productCategory = new ProductCategory();
        checkIfCategoryExists(addProductCategoryRequest.getCategoryId());
        ProductCategory productCategory=modelMapperService.getMapperRequest().map(addProductCategoryRequest,ProductCategory.class);
//        Category category = categoryService.getById(addProductCategoryRequest.getCategoryId());
//        productCategory.setCategory(category);
//        Product product = productService.getById(addProductCategoryRequest.getProductId());
//        productCategory.setProduct(product);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        AddProductCategoryResponse response=modelMapperService.getMapperResponse().map(savedProductCategory,AddProductCategoryResponse.class);

//        AddProductCategoryResponse response = new AddProductCategoryResponse(savedProductCategory.getId(),savedProductCategory.getCategory().getId(), savedProductCategory.getProduct().getId());
        return new SuccessDataResult<AddProductCategoryResponse>(response, Messages.ProductCategory.productCategoriesAddSuccesMessage);
    }

    private void checkIfCategoryExists(int id){
        boolean isExists = categoryRepository.existsById(id);
        if(!isExists) {
            //business exception
            throw new BusinessException(Messages.ProductCategory.ProductCategoryNotExistWithId);
        }
    }


//    private void checkIfCategoryExist(Category category){
//        List<Category> categories = categoryRepository.findAll();
//        for (Category categoryItem: categories
//             ) {
//            if (category.getId() != categoryItem.getId()){
//                throw new RuntimeException("Bu id'ye sahip kategori mevcut değil!");
//            }
//        }
//    }

}
