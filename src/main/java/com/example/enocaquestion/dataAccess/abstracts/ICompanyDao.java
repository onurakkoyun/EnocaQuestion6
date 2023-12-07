package com.example.enocaquestion.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.enocaquestion.entities.concretes.Company;

public interface ICompanyDao extends JpaRepository<Company, Long> {

}
