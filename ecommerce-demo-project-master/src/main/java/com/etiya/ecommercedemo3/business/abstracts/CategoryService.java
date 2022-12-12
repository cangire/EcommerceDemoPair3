package com.etiya.ecommercedemo3.business.abstracts;

import com.etiya.ecommercedemo3.business.dtos.request.category.AddCategoryRequest;
import com.etiya.ecommercedemo3.business.dtos.response.category.AddCategoryResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import com.etiya.ecommercedemo3.entities.concretes.Category;

import java.util.List;

public interface CategoryService {
    DataResult<List<Category>> getAll();
    DataResult<Category> getById(int id);
     DataResult<AddCategoryResponse> addCategory(AddCategoryRequest addCategoryRequest);
}
