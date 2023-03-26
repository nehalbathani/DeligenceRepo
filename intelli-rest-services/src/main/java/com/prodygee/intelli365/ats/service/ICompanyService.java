package com.prodygee.intelli365.ats.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.prodygee.intelli365.ats.model.Company;

public interface ICompanyService {
	
	public Company findCompanyById(Long id);
	public List<Company> findCompanies();
	public Company createCompany(Company company);
	public ResponseEntity<?> deleteCompany(Long id);
	public Company updateCompany(Company company, Long id);
	
}
