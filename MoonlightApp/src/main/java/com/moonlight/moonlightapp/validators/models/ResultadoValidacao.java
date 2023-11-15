package com.moonlight.moonlightapp.validators.models;

import java.util.ArrayList;
import java.util.List;

public class ResultadoValidacao {
    private final Boolean isValido;
    private final List<String> falhas;

    public ResultadoValidacao(boolean isValido) {
        this.isValido = isValido;
        falhas = new ArrayList<>();
    }

    public ResultadoValidacao(Boolean isValido, List<String> falhas) {
        this.isValido = isValido;
        this.falhas = falhas;
    }

    @Override
    public String toString() {
        return "ResultadoValidacao{" +
                "isValido=" + isValido +
                ", falhas=" + falhas +
                '}';
    }

    public List<String> getFalhas() {
        return falhas;
    }

    public boolean isValido() {
        return isValido;
    }
}
