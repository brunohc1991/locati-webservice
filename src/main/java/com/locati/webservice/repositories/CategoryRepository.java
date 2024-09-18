package com.locati.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.locati.webservice.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
