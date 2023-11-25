package com.moonlight.moonlightapp.validators;

import com.moonlight.moonlightapp.validators.models.ResultadoValidacao;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseValidator {
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
        return DefaultValidator.isBlankOrEmpty(input);
    }

    protected boolean isNull(Object input) {
        return DefaultValidator.isNull(input);
    }

    protected boolean isZeroOrNegativte(Integer input) {
        return DefaultValidator.isZeroOrNegativte(input);
    }

    protected boolean isZeroOrNegativte(Double input) {
        return DefaultValidator.isZeroOrNegative(input);
    }

    private void criarFalha(String falha) {
        if (!falhas.contains(falha)) {
            falhas.add(falha);
        }
    }
}
