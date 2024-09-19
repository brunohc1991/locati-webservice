package com.locati.webservice.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum ProductType {

	PROD_VENDA (0, "Venda Comum"),
	PROD_VENDA_RECORRENTE (1, "Venda Recorrente"),
	PROD_LOCACAO (2, "Locação");
	
	private int cod;
	private String description;

	private static final Map<Integer, ProductType> allType = new HashMap<>();

    static {
        for (ProductType type : ProductType.values()) {
        	allType.put(type.getCod(), type);
        }
    }

	private ProductType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public static ProductType fromCode(Integer cod) {
        if (cod == null) {
            return null;
        }
        ProductType result = allType.get(cod);
        if (result == null) {
            throw new IllegalArgumentException("Código inválido: " + cod);
        }
        return result;
    }
}
