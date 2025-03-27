package com.trabalho.ifood.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.ProdutoDTO;
import com.trabalho.ifood.domains.enums.StatusProduto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "produto")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
    private Long idProduto;

    @NotBlank@NotNull
    private String codigoBarra;

    @NotBlank @NotNull
    private String descricao;

    @NotNull
    @Digits(integer=15, fraction=3)
    private BigDecimal saldoEstoque;

    @NotNull
    @Digits(integer=15, fraction=3)
    private BigDecimal valorUnitario;

    @NotNull
    @Digits(integer=15, fraction=2)
    private BigDecimal valorEstoque;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "status")
    private StatusProduto status;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro = LocalDate.now();

    @ManyToOne
    @JoinColumn(name= "idgrupoproduto")
    private GrupoProduto grupoProduto;


    @JsonIgnore
    @OneToMany(mappedBy = "Produto")
    private List<Pedido> pedidos = new ArrayList<>();

    public Produto(){
        this.saldoEstoque =  BigDecimal.ZERO;
        this.valorUnitario = BigDecimal.ZERO;
        this.valorEstoque = BigDecimal.ZERO;
        this.status = StatusProduto.ATIVO;
    }

    public Produto(Long idProduto,String codigoBarra, String descricao, BigDecimal saldoEstoque,BigDecimal valorUnitario,
                   LocalDate dataCadastro, GrupoProduto grupoProduto, StatusProduto status){
        this.idProduto = idProduto;
        this.codigoBarra = codigoBarra;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.dataCadastro = dataCadastro;
        this.grupoProduto = grupoProduto;
        this.status = status;

        this.saldoEstoque = saldoEstoque !=null ? saldoEstoque : BigDecimal.ZERO;
        this.valorEstoque = saldoEstoque !=null ? saldoEstoque.multiply(valorUnitario) : BigDecimal.ZERO;
    }

    public Produto(ProdutoDTO dto) {
        this.idProduto = dto.getIdProduto();
        this.codigoBarra = dto.getCodigoBarra();
        this.descricao = dto.getDescricao();
        this.valorUnitario = dto.getValorUnitario();
        this.dataCadastro = dto.getDataCadastro();
        this.grupoProduto = new GrupoProduto();
        this.grupoProduto.setId(dto.getGrupoProduto());
        this.status = StatusProduto.toEnum(dto.getStatus());
        this.saldoEstoque = dto.getSaldoEstoque();
        this.valorEstoque = dto.getValorEstoque();
    }


    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public @NotBlank @NotNull String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(@NotBlank @NotNull String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getSaldoEstoque() {
        return saldoEstoque;
    }

    public void setSaldoEstoque(double saldoEstoque) {
        this.saldoEstoque = BigDecimal.valueOf(saldoEstoque);
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(@NotNull @Digits(integer = 0, fraction = 0) BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusProduto getStatus() {
        return status;
    }

    public void setStatus(StatusProduto status) {
        this.status = status;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(@NotNull @Digits(integer = 0, fraction = 0) BigDecimal valorEstoque) {
        this.valorEstoque = valorEstoque;
    }

    public GrupoProduto getGrupoProduto() {
        return grupoProduto;
    }

    public void setGrupoProduto(GrupoProduto grupoProduto) {
        this.grupoProduto = grupoProduto;
    }


    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return idProduto == produto.idProduto && Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, descricao);
    }
}