package com.locati.webservice.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum ClientType {

	PESSOA_FISICA (0, "Pessoa Física"),
	PESSOA_JURIDICA (1, "Pessoa Jurídica");
	
	private int cod;
	private String description;

	private static final Map<Integer, ClientType> allType = new HashMap<>();

    static {
        for (ClientType type : ClientType.values()) {
        	allType.put(type.getCod(), type);
        }
    }

	private ClientType(int cod, String description) {
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
	
	public static ClientType fromCode(Integer cod) {
        if (cod == null) {
            return null;
        }
        ClientType result = allType.get(cod);
        if (result == null) {
            throw new IllegalArgumentException("Código inválido: " + cod);
        }
        return result;
    }
}
