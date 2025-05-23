package com.drogaria.ceara.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "registro_ponto")
public class RegistroPonto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    private LocalDateTime dataHora;
    private String tipo;

    public RegistroPonto() {}

    public RegistroPonto(Funcionario funcionario, LocalDateTime dataHora, String tipo) {
        this.funcionario = funcionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public Funcionario getFuncionario() { return funcionario; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getTipo() { return tipo; }

    public void setId(Long id) { this.id = id; }
    public void setFuncionario(Funcionario funcionario) { this.funcionario = funcionario; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
