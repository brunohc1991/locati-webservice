package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
