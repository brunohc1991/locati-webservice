package com.locati.webservice.services.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<CPFouCNPJ, String> {
	
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	value = value.replaceAll("[^\\d]", "");
        return isValidCPF(value) || isValidCNPJ(value);
    }

    private boolean isValidCPF(String cpf) {
    	if (cpf.matches("(\\d)\\1{10}")) return false;
    	try {
            int sum1 = 0, sum2 = 0;
            for (int i = 0; i < 9; i++) {
                int digit = Character.getNumericValue(cpf.charAt(i));
                sum1 += digit * (10 - i);
                sum2 += digit * (11 - i);
            }

            int checkDigit1 = (sum1 * 10) % 11;
            if (checkDigit1 == 10) checkDigit1 = 0;

            sum2 += checkDigit1 * 2;
            int checkDigit2 = (sum2 * 10) % 11;
            if (checkDigit2 == 10) checkDigit2 = 0;

            return checkDigit1 == Character.getNumericValue(cpf.charAt(9))
                    && checkDigit2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }

    }

    private boolean isValidCNPJ(String cnpj) {
        if (cnpj.matches("(\\d)\\1{13}")) return false;

        try {
            int[] weights1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int[] weights2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int sum1 = 0, sum2 = 0;

            for (int i = 0; i < 12; i++) {
                int digit = Character.getNumericValue(cnpj.charAt(i));
                sum1 += digit * weights1[i];
                sum2 += digit * weights2[i];
            }

            int checkDigit1 = sum1 % 11 < 2 ? 0 : 11 - (sum1 % 11);
            sum2 += checkDigit1 * weights2[12];
            int checkDigit2 = sum2 % 11 < 2 ? 0 : 11 - (sum2 % 11);

            return checkDigit1 == Character.getNumericValue(cnpj.charAt(12))
                    && checkDigit2 == Character.getNumericValue(cnpj.charAt(13));
        } catch (Exception e) {
            return false;
        }
    }

}
