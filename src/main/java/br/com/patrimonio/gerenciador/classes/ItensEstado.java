package br.com.patrimonio.gerenciador.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ItensEstado {
    OCIOSO("ocioso"),
    QUEBRADO("quebrado"),
    NAOENCONTRADO("nao encontrado"),
    SEMPLAQUETA("sem plaqueta");

    private final String state;

    ItensEstado(String state) {
        this.state = state;
    }

    @JsonValue
    public String getState() {
        return state;
    }

    @JsonCreator
    public static ItensEstado fromValue(String value) {
        for (ItensEstado estado : ItensEstado.values()) {
            if (estado.state.equalsIgnoreCase(value)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Estado inválido: " + value);
    }
}
