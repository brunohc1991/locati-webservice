package com.locati.webservice.domain.enums;

import java.util.HashMap;
import java.util.Map;

public enum State {
	AC(0, "AC", "Acre"),
    AL(1, "AL", "Alagoas"),
    AM(2, "AM", "Amazonas"),
    AP(3, "AP", "Amapá"),
    BA(4, "BA", "Bahia"),
    CE(5, "CE", "Ceará"),
    DF(6, "DF", "Distrito Federal"),
    ES(7, "ES", "Espírito Santo"),
    GO(8, "GO", "Goiás"),
    MA(9, "MA", "Maranhão"),
    MG(10, "MG", "Minas Gerais"),
    MS(11, "MS", "Mato Grosso do Sul"),
    MT(12, "MT", "Mato Grosso"),
    PA(13, "PA", "Pará"),
    PB(14, "PB", "Paraíba"),
    PE(15, "PE", "Pernambuco"),
    PI(16, "PI", "Piauí"),
    PR(17, "PR", "Paraná"),
    RJ(18, "RJ", "Rio de Janeiro"),
    RN(19, "RN", "Rio Grande do Norte"),
    RO(20, "RO", "Rondônia"),
    RR(21, "RR", "Roraima"),
    RS(22, "RS", "Rio Grande do Sul"),
    SC(23, "SC", "Santa Catarina"),
    SE(24, "SE", "Sergipe"),
    SP(25, "SP", "São Paulo"),
    TO(26, "TO", "Tocantins");

    private int cod;
    private String sigla;
    private String nome;
    
    private static final Map<Integer, State> allState = new HashMap<>();

    static {
        for (State state : State.values()) {
        	allState.put(state.getCod(), state);
        }
    }

    private State(int cod, String sigla, String nome) {
        this.cod = cod;
        this.sigla = sigla;
        this.nome = nome;
    }

    public int getCod() {
        return cod;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
    
    public static State fromCode(Integer cod) {
        if (cod == null) {
            return null;
        }
        State result = allState.get(cod);
        if (result == null) {
            throw new IllegalArgumentException("Código inválido: " + cod);
        }
        return result;
    }
}
