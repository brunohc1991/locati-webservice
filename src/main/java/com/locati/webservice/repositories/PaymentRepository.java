package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{

}
