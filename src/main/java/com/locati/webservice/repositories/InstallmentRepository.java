package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Installment;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long>{

}
