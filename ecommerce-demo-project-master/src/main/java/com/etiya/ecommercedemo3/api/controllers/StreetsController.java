package com.etiya.ecommercedemo3.api.controllers;

import com.etiya.ecommercedemo3.business.abstracts.StreetService;
import com.etiya.ecommercedemo3.business.constants.Path;
import com.etiya.ecommercedemo3.business.dtos.request.street.AddStreetRequest;
import com.etiya.ecommercedemo3.business.dtos.response.street.AddStreetResponse;
import com.etiya.ecommercedemo3.business.dtos.response.street.GetAllStreetsResponse;
import com.etiya.ecommercedemo3.core.util.result.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Path.apiPrefix + "streets")
@AllArgsConstructor
public class StreetsController {
    private StreetService streetService;

    @PostMapping("/add")
    public ResponseEntity<DataResult<AddStreetResponse>> add(@RequestBody AddStreetRequest addStreetRequest) {
        return new ResponseEntity<>(streetService.addStreet(addStreetRequest), HttpStatus.CREATED);
    }

    @GetMapping("/getAllCitiesDto")
    public DataResult<List<GetAllStreetsResponse>> getAllDto(){
        return this.streetService.getAllDto();
    }

}
