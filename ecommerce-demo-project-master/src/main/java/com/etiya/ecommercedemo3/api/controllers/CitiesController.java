package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.CityService;
import com.etiya.ecommercedemo3.business.constants.Path;
import com.etiya.ecommercedemo3.business.dtos.request.city.AddCityRequest;
import com.etiya.ecommercedemo3.business.dtos.response.city.AddCityResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.apiPrefix + "cities")
@AllArgsConstructor
public class CitiesController {
    CityService cityService;


    @PostMapping("/add")
    ResponseEntity<DataResult<AddCityResponse>> add(@RequestBody AddCityRequest addCityRequest) {
        return new ResponseEntity<>(cityService.addCity(addCityRequest), HttpStatus.CREATED);}
}
