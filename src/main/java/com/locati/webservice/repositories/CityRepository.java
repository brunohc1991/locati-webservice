package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
