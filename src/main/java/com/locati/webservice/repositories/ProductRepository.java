package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
