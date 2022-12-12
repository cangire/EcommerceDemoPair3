package com.etiya.ecommercedemo3.business.concretes;

import com.etiya.ecommercedemo3.business.abstracts.CategoryService;
import com.etiya.ecommercedemo3.business.constants.Messages;
import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.cart.AddCartResponse;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.core.util.exceptions.BusinessException;
import com.etiya.ecommercedemo3.core.util.mapping.ModelMapperService;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.core.util.result.SuccessDataResult;
import com.etiya.ecommercedemo3.entities.concretes.Category;
import com.etiya.ecommercedemo3.repository.abstracts.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;

    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<Category>> getAll() {
        List<Category> response = categoryRepository.findAll();
        return new SuccessDataResult<List<Category>>(response, Messages.Category.CategoryGetAllSuccessMessage);
    }

    @Override
    public DataResult<Category> getById(int id) {
        Category response = categoryRepository.findById(id).orElseThrow();
        return new SuccessDataResult<Category>(response,Messages.Category.CategoryGetByIdSuccessMessage) ;
    }

    @Override
    public DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest) {
//        Category category = new Category();
//        category.setName(addCategoryRequest.getName());
        categoryCanNotExistWithSameName(addCategoryRequest.getName());

        Category category=modelMapperService.getMapperRequest().map(addCategoryRequest,Category.class);
        Category savedCategory = categoryRepository.save(category);

        AddCategoryResponse response= modelMapperService.getMapperResponse().map(savedCategory,AddCategoryResponse.class);
//                new AddCategoryResponse(savedCategory.getId(), savedCategory.getName());

        return new SuccessDataResult<AddCategoryResponse>(response,Messages.Category.CategoryAddSuccessMessage) ;

    }

    private void categoryCanNotExistWithSameName(String name){
        // Exception fırlatma
        boolean isExists = categoryRepository.existsCategoryByName(name);
        if(isExists)
            throw new BusinessException(Messages.Category.CategoryExistWithSameName);
    }

}
