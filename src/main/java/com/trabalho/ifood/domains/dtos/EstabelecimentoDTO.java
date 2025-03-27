package com.trabalho.ifood.domains.dtos;


import com.trabalho.ifood.domains.Estabelecimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class EstabelecimentoDTO {

    private Integer idEstab;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode estar vazio")
    private String cnpj;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotNull(message = "O campo tipoCulinaria não pode ser nulo")
    @NotBlank(message = "O campo tipoCulinaria não pode estar vazio")
    private String tipoCulinaria;

    @NotNull(message = "O campo notaAvaliacao não pode ser nulo")
    @NotBlank(message = "O campo notaAvaliacao não pode estar vazio")
    private String notaAvaliacao;

    @NotNull(message = "O campo valorFrete não pode ser nulo")
    @NotBlank(message = "O campo valorFrete não pode estar vazio")
    private BigDecimal valorFrete;

    public EstabelecimentoDTO() {
    }

    public EstabelecimentoDTO(Estabelecimento estabelecimento) {
        this.idEstab = estabelecimento.getIdEstab();
        this.cnpj = estabelecimento.getCnpj();
        this.nome = estabelecimento.getNome();
        this.tipoCulinaria = estabelecimento.getTipoCulinaria();
        this.notaAvaliacao = estabelecimento.getNotaAvaliacao();
        this.valorFrete = estabelecimento.getValorFrete();
    }

    public Integer getIdEstab() {
        return idEstab;
    }

    public void setIdEstab(Integer idEstab) {
        this.idEstab = idEstab;
    }

    public @NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode estar vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode estar vazio") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo tipoCulinaria não pode ser nulo") @NotBlank(message = "O campo tipoCulinaria não pode estar vazio") String getTipoCulinaria() {
        return tipoCulinaria;
    }

    public void setTipoCulinaria(@NotNull(message = "O campo tipoCulinaria não pode ser nulo") @NotBlank(message = "O campo tipoCulinaria não pode estar vazio") String tipoCulinaria) {
        this.tipoCulinaria = tipoCulinaria;
    }

    public @NotNull(message = "O campo notaAvaliacao não pode ser nulo") @NotBlank(message = "O campo notaAvaliacao não pode estar vazio") String getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(@NotNull(message = "O campo notaAvaliacao não pode ser nulo") @NotBlank(message = "O campo notaAvaliacao não pode estar vazio") String notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public @NotNull(message = "O campo valorFrete não pode ser nulo") @NotBlank(message = "O campo valorFrete não pode estar vazio") BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(@NotNull(message = "O campo valorFrete não pode ser nulo") @NotBlank(message = "O campo valorFrete não pode estar vazio") BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }
}