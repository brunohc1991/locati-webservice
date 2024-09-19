package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
