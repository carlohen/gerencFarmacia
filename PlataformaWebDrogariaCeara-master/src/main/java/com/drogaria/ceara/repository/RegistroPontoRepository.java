package com.drogaria.ceara.repository;


import com.drogaria.ceara.model.RegistroPonto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RegistroPontoRepository extends JpaRepository<RegistroPonto, Long> {

    List<RegistroPonto> findByFuncionario_Id(Long funcionarioId);

}

