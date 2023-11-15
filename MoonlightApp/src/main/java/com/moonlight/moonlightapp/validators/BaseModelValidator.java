package com.moonlight.moonlightapp.validators;

public class BaseModelValidator {
    protected ResultadoValidacao resultado = new ResultadoValidacao(true);

    private void criarFalha(String falha) {
        resultado.setValido(false);
        resultado.getFalhas().add(falha);
    }

    protected void build(ResultadoValidacao resultadoValidacao) {
        resultadoValidacao.getFalhas().forEach(falha -> criarFalha(falha));
    }

    protected void build(String falha) {
        criarFalha(falha);
    }
}
