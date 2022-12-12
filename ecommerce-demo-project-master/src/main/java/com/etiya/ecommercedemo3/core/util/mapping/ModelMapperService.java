package com.etiya.ecommercedemo3.core.util.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper getMapperRequest();
    ModelMapper getMapperResponse();
}
