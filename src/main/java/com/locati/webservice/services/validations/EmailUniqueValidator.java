package com.locati.webservice.services.validations;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.locati.webservice.domain.Client;
import com.locati.webservice.repositories.ClientRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private HttpServletRequest request;
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	
    	Map<String, String> mapRequest = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    	Integer id = mapRequest.containsKey("id") ? Integer.parseInt(mapRequest.get("id")) : 0;
    	Client cli = repository.findByEmail(value);
    	
        return cli == null || cli.getId().longValue() == id.longValue();
    }

}
