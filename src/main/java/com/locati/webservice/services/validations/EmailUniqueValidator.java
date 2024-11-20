package com.locati.webservice.services.validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.locati.webservice.domain.Client;
import com.locati.webservice.repositories.ClientRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
	
	@Autowired
	private ClientRepository repository;
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	Client cli = repository.findByEmail(value);
        return cli == null;
    }

}
