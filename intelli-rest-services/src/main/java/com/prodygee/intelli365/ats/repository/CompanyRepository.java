package com.prodygee.intelli365.ats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodygee.intelli365.ats.model.Company;



@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}