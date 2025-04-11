package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "my_manager_employe")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "Data de nascimento é obrigatória")
    private String dataNascimento;

    @NotNull(message = "Sexo é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull(message = "Setor é obrigatório")
    @Enumerated(EnumType.STRING)
    private Setor setor;

    @NotNull(message = "Estado civil é obrigatório")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @NotNull(message = "Salário é obrigatório")
    private Double salario;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    @NotNull(message = "Endereço é obrigatório")
    @Embedded
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(Long id, String nome, String cpf, String dataNascimento, Sexo sexo, Setor setor,
                       EstadoCivil estadoCivil, Double salario, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.setor = setor;
        this.estadoCivil = estadoCivil;
        this.salario = salario;
        this.email = email;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
