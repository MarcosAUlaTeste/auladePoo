package com.example.demo.controller;

import com.example.demo.model.Funcionario;
import com.example.demo.service.FuncionarioServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/func")
public class FuncionarioController {
    private FuncionarioServico funcionarioServico;

    public FuncionarioController(FuncionarioServico funcionarioServico) {
        this.funcionarioServico = funcionarioServico;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodos(){
        return ResponseEntity.ok(funcionarioServico.listarTodosFuncionarios());
    }

    @PostMapping
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        Funcionario novo = funcionarioServico.criar(funcionario);
        return ResponseEntity.status(201).body(novo);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestBody Map<String, Long> payLoad) {
        Long id = payLoad.get("id");

        try {
            funcionarioServico.deletar(id);
            return ResponseEntity.noContent().build();
        } catch(RuntimeException e) {
            return  ResponseEntity.notFound().build();
        }
    }






}
