package com.bootcamp.spring.data.api.http;

import com.bootcamp.spring.data.api.http.request.CreateEmployerCommand;
import com.bootcamp.spring.data.api.http.request.EditEmployerCommand;
import com.bootcamp.spring.data.domain.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class EmployerController {

	private EmployerService employerService;

	public EmployerController(EmployerService employerService) {
		this.employerService = employerService;
	}

	@RequestMapping(method = POST, value = "api/v1/employers", produces = "application/json")
	public ResponseEntity createEmployer(@Valid @RequestBody CreateEmployerCommand command) {
	    var employer = employerService.createEmployer(command);
		return new ResponseEntity<>(employer, HttpStatus.OK);
	}

	@RequestMapping(method = GET, value = "api/v1/employers/{uuid}", produces = "application/json")
	public ResponseEntity getEmployerByUuid(@PathVariable final String uuid) {
		var employer = employerService.getEmployerByUuid(UUID.fromString(uuid));
		return new ResponseEntity<>(employer, HttpStatus.OK);
	}

	@RequestMapping(method = PUT, value = "api/v1/employers/{uuid}", produces = "application/json")
	public ResponseEntity editEmployerByUuid(@PathVariable final String uuid, @Valid @RequestBody EditEmployerCommand command) {
		var employer = employerService.editEmployerByUuid(UUID.fromString(uuid), command);
		return new ResponseEntity<>(employer, HttpStatus.OK);
	}

	@RequestMapping(method = DELETE, value = "api/v1/employers/{uuid}", produces = "application/json")
	public ResponseEntity deleteEmployerByUuid(@PathVariable final String uuid) {
		 employerService.deleteEmployerByUuid(UUID.fromString(uuid));
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
