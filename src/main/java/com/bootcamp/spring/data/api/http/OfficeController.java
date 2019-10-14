package com.bootcamp.spring.data.api.http;

import com.bootcamp.spring.data.api.http.request.CreateOfficeRequest;
import com.bootcamp.spring.data.domain.service.OfficeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class OfficeController {

    private OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(method = POST, value = "api/v1/offices", produces = "application/json")
    public ResponseEntity createOffice(@Valid @RequestBody CreateOfficeRequest command) {
        var employer = officeService.createOffice(command);
        return new ResponseEntity<>(employer, HttpStatus.OK);
    }
}
