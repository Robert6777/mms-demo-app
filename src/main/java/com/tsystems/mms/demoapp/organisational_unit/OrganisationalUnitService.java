package com.tsystems.mms.demoapp.organisational_unit;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tsystems.mms.demoapp.dto.UnitDto;
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






	public List<UnitDto> getAll() {
		return repository.findAll().stream().map(UnitDto::new).collect(Collectors.toList());
	}

}
