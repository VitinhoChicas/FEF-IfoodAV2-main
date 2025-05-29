package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_pessoa")
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa" , allocationSize = 1)
    protected Long idPessoa;

    @NotNull
    @NotBlank
    protected String nome;

    @NotNull
    @NotBlank
    protected String endereco;

    @NotNull
    @NotBlank
    protected String telefone;

    @Column(unique = true)
    protected String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createdAt;

@ElementCollection(fetch = FetchType.EAGER)
@CollectionTable(name = "pessoas" , joinColumns = @JoinColumn (name = "pessoa_id"))
@Column(name = "person_type")
protected Set<Integer> tipoPessoa = new HashSet<>();


    public Pessoa() {
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Pessoa(Long idPessoa, String nome, String endereco, String telefone, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public @NotNull @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotNull @NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull @NotBlank String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotNull @NotBlank String telefone) {
        this.telefone = telefone;
    }

    public @NotNull @NotBlank String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotNull @NotBlank String endereco) {
        this.endereco = endereco;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Set<TipoPessoa> getTipoPessoa() {
        return tipoPessoa.stream().map(TipoPessoa::toEnum).collect(Collectors.toSet());
    }

    public void addTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa.add(tipoPessoa.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(idPessoa, pessoa.idPessoa) && Objects.equals(cpf, pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa, cpf);
    }
}
