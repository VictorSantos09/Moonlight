package com.moonlight.moonlightapp.dtos;

public final class BaseDTO {
    private String mensagem;
    private Boolean isSucesso;
    private Boolean isException;
    private  Object data;

    public BaseDTO(String mensagem, Boolean isSucesso, Object data, Boolean isException) {
        this.mensagem = mensagem;
        this.isSucesso = isSucesso;
        this.data = data;
        this.isException = isException;
    }

    public static BaseDTO buildSucesso(String mensagem) {
        return new BaseDTO(mensagem, true, null, false);
    }

    public static <T> BaseDTO buildSucesso(String mensagem, T data) {
        return new BaseDTO(mensagem, true, data, false);
    }

    public static BaseDTO buildFalha(String mensagem) {
        return new BaseDTO(mensagem, false, null, false);
    }

    public static <T> BaseDTO buildFalha(String mensagem, T data) {
        return new BaseDTO(mensagem, false, data, false);
    }

    public static BaseDTO build(String mensagem, Boolean isSucesso, Boolean isException) {
        return new BaseDTO(mensagem, isSucesso, null, isException);
    }

    public static <T> BaseDTO build(String mensagem, T data, Boolean isSucesso, Boolean isException) {
        return new BaseDTO(mensagem, isSucesso, data, isException);
    }

    public static BaseDTO buildException(Exception e) {
        return new BaseDTO(e.getMessage(), false, e.getMessage(), true);
    }

    @Override
    public String toString() {
        return String.format("Mensagem: %s, Sucesso: %s, Data: %s", this.mensagem, this.isSucesso, this.data);
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Boolean getIsSucesso() {
        return isSucesso;
    }

    public void setIsSucesso(Boolean isSucesso) {
        this.isSucesso = isSucesso;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSucesso() {
        return isSucesso;
    }

    public void setSucesso(Boolean sucesso) {
        isSucesso = sucesso;
    }

    public Boolean getException() {
        return isException;
    }

    public void setException(Boolean exception) {
        isException = exception;
    }
}
