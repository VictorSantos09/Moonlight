package com.moonlight.moonlightapp.validators;

import java.util.ArrayList;
import java.util.List;

public class BaseValidator {
    protected final List<String> falhas;

    public BaseValidator() {
        falhas = new ArrayList<>();
    }

    public List<String> getFalhas() {
        return falhas;
    }

    protected void addFailure(ResultadoValidacao resultadoValidacao) {
        resultadoValidacao.getFalhas().forEach(this::criarFalha);
    }

    protected void addFailure(String falha) {
        criarFalha(falha);
    }

    protected void addFailure(List<String> falhas) {
        falhas.forEach(this::addFailure);
    }

    protected ResultadoValidacao build() {
        if (falhas.isEmpty()) {
            return new ResultadoValidacao(true);
        }

        return new ResultadoValidacao(false, falhas);
    }

    protected boolean isBlankOrEmpty(String input) {
        return isNull(input) || input.isEmpty() || input.isBlank();
    }

    protected boolean isNull(Object input) {
        return input == null;
    }

    protected boolean isZeroOrNegativte(Integer input) {
        return isNull(input) || input <= 0;
    }

    protected boolean isZeroOrNegativte(Double input) {
        return isNull(input) || input <= 0;
    }


    private void criarFalha(String falha) {
        if (falhas.contains(falha)) {
            return;

        } else {
            falhas.add(falha);
        }
    }
}
