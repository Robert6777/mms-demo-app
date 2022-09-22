package com.tsystems.mms.demoapp.organisational_unit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.user.User;

@Service
@Transactional
public class OrganisationalUnitService {
	
	private OrganisationalUnitRepository repository;
	
	
	
	
	
	@Autowired
	public OrganisationalUnitService(OrganisationalUnitRepository oganisationRepository) {
		super();
		this.repository = oganisationRepository;
	}






	public List<OrganisationalUnit> getAll() {
		return repository.findAll();
	}

}
