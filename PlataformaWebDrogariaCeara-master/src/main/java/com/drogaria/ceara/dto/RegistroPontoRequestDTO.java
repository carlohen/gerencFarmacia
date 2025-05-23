package com.drogaria.ceara.dto;

public class RegistroPontoRequestDTO {
    private Long funcionarioId;
    private String tipo;

    public RegistroPontoRequestDTO() {}

    public Long getFuncionarioId() { return funcionarioId; }
    public String getTipo() { return tipo; }

    public void setFuncionarioId(Long funcionarioId) { this.funcionarioId = funcionarioId; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
