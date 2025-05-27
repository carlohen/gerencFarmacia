package com.drogaria.ceara.controller;

import com.drogaria.ceara.dto.RegistroPontoRequestDTO;
import com.drogaria.ceara.dto.RegistroPontoResponseDTO;
import com.drogaria.ceara.service.RegistroPontoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/ponto")
public class RegistroPontoController {

    private final RegistroPontoService service;

    public RegistroPontoController(RegistroPontoService service) {
        this.service = service;
    }

    // Registrar entrada ou saída
    @PostMapping
    public RegistroPontoResponseDTO registrar(@RequestBody RegistroPontoRequestDTO dto) {
        return service.registrar(dto);
    }

    // Listar todos os registros de ponto
    @GetMapping
    public List<RegistroPontoResponseDTO> listarTodos() {
        return service.listarTodos();
    }

    // Listar ponto de um funcionário específico
    @GetMapping("/funcionario/{id}")
    public List<RegistroPontoResponseDTO> listarPorFuncionario(@PathVariable Long id) {
        return service.listarPorFuncionario(id);
    }
}
