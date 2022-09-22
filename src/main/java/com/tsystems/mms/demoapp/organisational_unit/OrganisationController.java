package com.tsystems.mms.demoapp.organisational_unit;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tsystems.mms.demoapp.dto.UnitDto;
import com.tsystems.mms.demoapp.user.User;
import com.tsystems.mms.demoapp.user.UserController;

@RestController
@RequestMapping("/api/v1.0/organisation")
public class OrganisationController {
	
	private OrganisationalUnitService service;
	 private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	
	@Autowired
	public OrganisationController(OrganisationalUnitService service) {
		super();
		this.service = service;
	}
	
	  @GetMapping()
	  public ResponseEntity<List<UnitDto>> getUsers() {

	    LOGGER.info("Get all organisational units from the database");
	    return ResponseEntity.ok(service.getAll());
	  }
	
	

}
