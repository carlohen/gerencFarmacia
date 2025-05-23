package com.drogaria.ceara.service;

import com.drogaria.ceara.dto.RegistroPontoRequestDTO;
import com.drogaria.ceara.dto.RegistroPontoResponseDTO;
import com.drogaria.ceara.model.Funcionario;
import com.drogaria.ceara.model.RegistroPonto;
import com.drogaria.ceara.repository.FuncionarioRepository;
import com.drogaria.ceara.repository.RegistroPontoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistroPontoService {

    private final RegistroPontoRepository repository;
    private final FuncionarioRepository funcionarioRepository;

    public RegistroPontoService(RegistroPontoRepository repository, FuncionarioRepository funcionarioRepository) {
        this.repository = repository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public RegistroPontoResponseDTO registrar(RegistroPontoRequestDTO dto) {
        Funcionario funcionario = funcionarioRepository.findById(dto.getFuncionarioId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        RegistroPonto ponto = new RegistroPonto(
                funcionario,
                LocalDateTime.now(),
                dto.getTipo()
        );

        RegistroPonto salvo = repository.save(ponto);
        return RegistroPontoResponseDTO.fromEntity(salvo);
    }

    public List<RegistroPontoResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(RegistroPontoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public List<RegistroPontoResponseDTO> listarPorFuncionario(Long funcionarioId) {
        return repository.findByFuncionario_Id(funcionarioId).stream()
                .map(RegistroPontoResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
