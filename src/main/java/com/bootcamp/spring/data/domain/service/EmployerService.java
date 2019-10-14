package com.bootcamp.spring.data.domain.service;

import com.bootcamp.spring.data.api.http.OfficeController;
import com.bootcamp.spring.data.api.http.request.CreateEmployerCommand;
import com.bootcamp.spring.data.api.http.request.EditEmployerCommand;
import com.bootcamp.spring.data.core.exceptionhandler.exceptions.EmployerAlreadyExistsException;
import com.bootcamp.spring.data.core.exceptionhandler.exceptions.OfficeNotFoundException;
import com.bootcamp.spring.data.domain.model.Employer;
import com.bootcamp.spring.data.domain.model.Office;
import com.bootcamp.spring.data.infrastructure.persistence.EmployerRepository;
import com.bootcamp.spring.data.core.exceptionhandler.exceptions.EmployerNotFoundException;
import com.bootcamp.spring.data.infrastructure.persistence.OfficeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class EmployerService {
	private EmployerRepository employerRepository;
	private OfficeRepository officeRepository;

	public EmployerService(EmployerRepository employerRepository, OfficeRepository officeController) {
		this.employerRepository = employerRepository;
		this.officeRepository = officeController;
	}

	@Transactional(rollbackFor = Exception.class)
	public Employer createEmployer(CreateEmployerCommand command) {
		var optionalEmployer = employerRepository.findByDisplayId(command.displayId);
		if(optionalEmployer.isPresent()) {
			throw new EmployerAlreadyExistsException("Employer already exists: " + command.displayId);
		}
		var optionalOffice = officeRepository.findByAddress(command.address);
		if(!optionalOffice.isPresent()) {
			throw new OfficeNotFoundException("Office not found at: " + command.address);
		}
	    var employer = new Employer(
	    		UUID.randomUUID(),
				command.type,
				command.name,
				command.displayId,
				command.email,
				optionalOffice.get()
		);
		return employerRepository.save(employer);
	}

	public Employer getEmployerByUuid(UUID uuid) {
		var optionalEmployer = employerRepository.findByUuid(uuid);
		if(optionalEmployer.isPresent()) {
		    return optionalEmployer.get();
		}
		throw new EmployerNotFoundException("Employer not found: " + uuid.toString());
	}

	@Transactional(rollbackFor = Exception.class)
	public Employer editEmployerByUuid(final UUID uuid, EditEmployerCommand command) {
	    var employer = this.getEmployerByUuid(uuid);
		employer
				.setName(command.name)
				.setEmail(command.email);
		return employerRepository.save(employer);
	}

	public void deleteEmployerByUuid(final UUID uuid) {
	    var employer = this.getEmployerByUuid(uuid);
	    this.employerRepository.delete(employer);
	}
}
