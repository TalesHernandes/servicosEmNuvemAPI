package com.projeto.ProjetoFunc.repository;


import com.projeto.ProjetoFunc.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    @Query("SELECT f FROM Funcionario f WHERE LOWER(f.nome) = LOWER(:nome)")
    Optional<Funcionario> findByNomeIgnoreCase(@Param("nome") String nome);

}


