package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
