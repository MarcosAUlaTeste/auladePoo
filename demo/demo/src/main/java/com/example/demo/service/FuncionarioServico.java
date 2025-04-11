package com.example.demo.service;

import com.example.demo.model.Funcionario;
import com.example.demo.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServico {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodosFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarPorId(Long id) {
        return  funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Funcionario criar(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(Long id, Funcionario funcionarioAtualizado){
        Funcionario funcionarioExistente = buscarPorId(id);

        funcionarioExistente.setNome(funcionarioAtualizado.getNome());
        funcionarioExistente.setEmail(funcionarioAtualizado.getEmail());
        funcionarioExistente.setCpf(funcionarioAtualizado.getCpf());
        funcionarioExistente.setEndereco(funcionarioAtualizado.getEndereco());
        funcionarioExistente.setEstadoCivil(funcionarioAtualizado.getEstadoCivil());
        funcionarioExistente.setSetor(funcionarioAtualizado.getSetor());

        return  funcionarioRepository.save(funcionarioExistente);
    }

    public void deletar(long id) {
        funcionarioRepository.deleteById(id);
    }
}
