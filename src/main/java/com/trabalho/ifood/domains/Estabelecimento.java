package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.EstabelecimentoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_estabelecimento")
    private Integer idEstab;

    @NotNull @NotBlank
    private String cnpj;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String tipoCulinaria;

    @NotNull @NotBlank
    private String notaAvaliacao;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valorFrete;

    @JsonIgnore
    @OneToMany(mappedBy = "Estabelecimento")
    private List<Pedido> pedidos = new ArrayList<>();

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public Estabelecimento() {
    }

    public Estabelecimento(Integer idEstab, String cnpj, String nome, String tipoCulinaria, String notaAvaliacao, BigDecimal valorFrete ) {
        this.idEstab = idEstab;
        this.cnpj = cnpj;
        this.nome = nome;
        this.tipoCulinaria = tipoCulinaria;
        this.notaAvaliacao = notaAvaliacao;
        this.valorFrete = valorFrete;
    }

    public Estabelecimento(EstabelecimentoDTO dto) {
        this.idEstab = dto.getIdEstab();
        this.cnpj = dto.getCnpj();
        this.nome = dto.getNome();
        this.tipoCulinaria = dto.getTipoCulinaria();
        this.notaAvaliacao = dto.getNotaAvaliacao();
        this.valorFrete = dto.getValorFrete();
    }

    public Integer getIdEstab() {
        return idEstab;
    }

    public void setIdEstab(Integer id) {
        this.idEstab = id;
    }

    public @NotNull @NotBlank String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull @NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getTipoCulinaria() {
        return tipoCulinaria;
    }

    public void setTipoCulinaria(@NotNull @NotBlank String tipoCulinaria) {
        this.tipoCulinaria = tipoCulinaria;
    }

    public @NotNull @NotBlank String getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(@NotNull @NotBlank String notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valorFrete) {
        this.valorFrete = valorFrete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estabelecimento that = (Estabelecimento) o;
        return Objects.equals(idEstab, that.idEstab) && Objects.equals(cnpj, that.cnpj) && Objects.equals(nome, that.nome) && Objects.equals(tipoCulinaria, that.tipoCulinaria) && Objects.equals(notaAvaliacao, that.notaAvaliacao) && Objects.equals(valorFrete, that.valorFrete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstab, cnpj, nome, tipoCulinaria, notaAvaliacao, valorFrete);
    }
}
