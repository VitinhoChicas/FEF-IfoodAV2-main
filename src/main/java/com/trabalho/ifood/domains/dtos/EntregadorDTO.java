package com.trabalho.ifood.domains.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.Cliente;
import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.enums.TipoPessoa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EntregadorDTO {
    protected Long id;


    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotBlank(message = "O campo Nome não pode estar vazio ")
    protected String nome;

    @NotNull(message = "O campo endereco não pode ser Nulo")
    @NotBlank (message = "O campo endereco não pode estar vazio")
    protected String endereco;

    @NotNull(message = "O campo telefone não pode ser Nulo")
    @NotBlank (message = "O campo telefone não pode estar vazio")
    protected String telefone;

    @NotNull(message = "O campo cpf não pode ser Nulo")
    @NotBlank (message = "O campo cpf não pode estar vazio")
    protected String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt = LocalDate.now();

    protected Set<Integer> tipoPessoa = new HashSet<>();

    public EntregadorDTO() {

    }

    public EntregadorDTO(Entregador obj){
        this.id = obj.getIdPessoa();
        this.nome = obj.getNome();
        this.endereco = obj.getEndereco();
        this.telefone = obj.getTelefone();
        this.cpf = obj.getCpf();
        this.createdAt = obj.getCreatedAt();
        this.tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode estar vazio ") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode estar vazio ") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo endereco não pode ser Nulo") @NotBlank(message = "O campo endereco não pode estar vazio") String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull(message = "O campo endereco não pode ser Nulo") @NotBlank(message = "O campo endereco não pode estar vazio") String endereco) {
        this.endereco = endereco;
    }

    public @NotNull(message = "O campo telefone não pode ser Nulo") @NotBlank(message = "O campo telefone não pode estar vazio") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull(message = "O campo telefone não pode ser Nulo") @NotBlank(message = "O campo telefone não pode estar vazio") String telefone) {
        this.telefone = telefone;
    }

    public @NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull(message = "O campo cpf não pode ser Nulo") @NotBlank(message = "O campo cpf não pode estar vazio") String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa == null ? Collections.emptySet() :
                tipoPessoa.stream().map(com.trabalho.ifood.domains.enums.TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }
}
