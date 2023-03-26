package com.prodygee.intelli365.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodygee.intelli365.ats.model.Company;
import com.prodygee.intelli365.ats.service.ICompanyService;
import com.prodygee.intelli365.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/intelli365")
public class ATSController {

    @Autowired
    ICompanyService companyService;

    
  @GetMapping("/companies/{id}")
    public Company getCompanybyId(@PathVariable(value = "id") Long companyId) {
        return companyService.findCompanyById(companyId)
                ;
    }
    
    
    @GetMapping("/companies")
    public List<Company> getAll() {
        return companyService.findCompanies();
    }

    
    @PutMapping("/companies/{id}")
    public Company updateCompany(@PathVariable(value = "id") Long companyId,
                                            @Valid @RequestBody Company comp) {
    	
    	return companyService.updateCompany(comp, companyId);

       
    }
    
    
    @PostMapping("/companies")
    public Company createCompany(@Valid @RequestBody Company company) {
        return companyService.createCompany(company);
    }
    
    
    @DeleteMapping("/companies/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable(value = "id") Long companyId) {
    	return companyService.deleteCompany(companyId);
    	
       
    }
    
    
    // Create a new Note

    // Get a Single Note

    // Update a Note

    // Delete a Note
}