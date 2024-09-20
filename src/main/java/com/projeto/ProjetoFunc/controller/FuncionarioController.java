package com.projeto.ProjetoFunc.controller;

import com.projeto.ProjetoFunc.model.Funcionario;
import com.projeto.ProjetoFunc.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/{nome}")
    public Funcionario getFuncionario(@PathVariable String nome) {
        Optional<Funcionario> funcionario = funcionarioRepository.findByNomeIgnoreCase(nome);

        if (funcionario.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Funcionario nao encontrado"
            );
        }

        return funcionario.get();
    }

}
