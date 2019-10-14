package com.bootcamp.spring.data.domain.service;

import com.bootcamp.spring.data.api.http.request.CreateOfficeRequest;
import com.bootcamp.spring.data.domain.model.Office;
import com.bootcamp.spring.data.infrastructure.persistence.OfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficeService {
    private OfficeRepository officeRepository;

    public OfficeService(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    public Office createOffice(CreateOfficeRequest createOfficeRequest) {
        var office = new Office(
                createOfficeRequest.name,
                createOfficeRequest.address,
                createOfficeRequest.city
        );
        return this.officeRepository.save(office);
    }
}
