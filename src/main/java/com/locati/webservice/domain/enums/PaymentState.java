package com.locati.webservice.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum PaymentState {

	PENDING (0, "Pendente"),
	PAID (1, "Pago"),
	CANCELLED (2, "Cancelado");
	
	private int cod;
	private String description;

	private static final Map<Integer, PaymentState> allState = new HashMap<>();

    static {
        for (PaymentState type : PaymentState.values()) {
        	allState.put(type.getCod(), type);
        }
    }

	private PaymentState(int cod, String description) {
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
	
	public static PaymentState fromCode(Integer cod) {
        if (cod == null) {
            return null;
        }
        PaymentState result = allState.get(cod);
        if (result == null) {
            throw new IllegalArgumentException("Código inválido: " + cod);
        }
        return result;
    }
}
