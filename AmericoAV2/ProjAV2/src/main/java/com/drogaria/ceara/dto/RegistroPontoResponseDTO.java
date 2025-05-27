package com.drogaria.ceara.dto;

import com.drogaria.ceara.model.RegistroPonto;

import java.time.LocalDateTime;

public class RegistroPontoResponseDTO {
    private Long id;
    private String nomeFuncionario;
    private LocalDateTime dataHora;
    private String tipo;

    public RegistroPontoResponseDTO(Long id, String nomeFuncionario, LocalDateTime dataHora, String tipo) {
        this.id = id;
        this.nomeFuncionario = nomeFuncionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public String getNomeFuncionario() { return nomeFuncionario; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getTipo() { return tipo; }

    public static RegistroPontoResponseDTO fromEntity(RegistroPonto registro) {
        return new RegistroPontoResponseDTO(
                registro.getId(),
                registro.getFuncionario().getNomeCompleto(),
                registro.getDataHora(),
                registro.getTipo()
        );
    }
}
