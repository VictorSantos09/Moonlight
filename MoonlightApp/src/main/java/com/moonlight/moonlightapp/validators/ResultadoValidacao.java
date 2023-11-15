package com.moonlight.moonlightapp.validators;

import java.util.ArrayList;
import java.util.List;

public class ResultadoValidacao {
    private boolean isValido;
    private List<String> falhas;

    public ResultadoValidacao(boolean isValido) {
        this.isValido = isValido;
        falhas = new ArrayList<>();
    }

    public List<String> getFalhas() {
        return falhas;
    }

    public void setFalhas(List<String> falhas) {
        this.falhas = falhas;
    }

    public boolean isValido() {
        return isValido;
    }

    public void setValido(boolean isValido) {
        this.isValido = isValido;
    }
}
