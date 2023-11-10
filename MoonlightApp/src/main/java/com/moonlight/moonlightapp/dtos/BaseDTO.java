package com.moonlight.moonlightapp.dtos;

public final class BaseDTO {
    private String mensagem;
    private Boolean isSucesso;
    private Object data;

    public BaseDTO(String mensagem, Boolean isSucesso, Object data) {
        this.mensagem = mensagem;
        this.isSucesso = isSucesso;
        this.data = data;
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

    public static BaseDTO BuildSucesso(String mensagem, Object data) {
        return new BaseDTO(mensagem, true, data);
    }

    public static BaseDTO BuildFalha(String mensagem, Object data) {
        return new BaseDTO(mensagem, false, data);
    }

    public static BaseDTO Build(String mensagem, Boolean isSucesso, Object data) {
        return new BaseDTO(mensagem, isSucesso, data);
    }

    public static BaseDTO BuildException(Exception e) {
        return new BaseDTO(e.getMessage(), false, null);
    }
}
