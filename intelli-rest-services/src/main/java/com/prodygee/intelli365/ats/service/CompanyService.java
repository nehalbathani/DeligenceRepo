package com.prodygee.intelli365.ats.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodygee.intelli365.ats.model.Company;
import com.prodygee.intelli365.ats.repository.CompanyRepository;
import com.prodygee.intelli365.exception.ResourceNotFoundException;


@Service
@Transactional
public class CompanyService implements ICompanyService {
	
	private CompanyRepository companyRepository;
	
	@Autowired
	public CompanyService(CompanyRepository companyRepository) {
		super();
		this.companyRepository = companyRepository;
	}

	@Override
	public Company findCompanyById( Long companyId) {
			
		 return companyRepository.findById(companyId)
		            .orElseThrow(() -> new ResourceNotFoundException("Company", "ID", companyId));
		
	}

	@Override
	public List<Company> findCompanies() {
		return companyRepository.findAll();
	}

	
	@Override
	public Company updateCompany(Company company,  Long companyId) {
	
		Company comp =  companyRepository.findById(companyId)
         .orElseThrow(() -> new ResourceNotFoundException("Company", "ID", companyId));

	    comp.setCompanyName(company.getCompanyName());

	    Company updatedCompany = companyRepository.save(comp);
	    return updatedCompany;
	}

	@Override
	public Company createCompany(Company company) {
		return companyRepository.save(company);
	}

	@Override
	public ResponseEntity<?> deleteCompany(Long id) {
		Company company = companyRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Company", "id", id));

		companyRepository.delete(company);

	    return ResponseEntity.ok().build();
	}
	
	
	

}
