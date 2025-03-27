package com.trabalho.ifood.domains;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.dtos.PedidoDTO;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    private String descricaoPedido;

    @NotNull
    @NotBlank
    private String tempoEspera;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "statusPedido")
    private StatusPedido statusPedido;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "tipoEntrega")
    private TipoEntrega tipoEntrega;

    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="idEntregador")
    private Entregador entregador;

    @ManyToOne
    @JoinColumn(name="idEstabelecimento")
    private Estabelecimento Estabelecimento;

    @ManyToOne
    @JoinColumn(name="idProduto")
    private Produto Produto;

    public Pedido() {
        this.valor = BigDecimal.ZERO;
        this.statusPedido= StatusPedido.PENDENTE;
        this.tipoEntrega = TipoEntrega.ENTREGA;
    }

    public Pedido(UUID id, String descricaoPedido, String tempoEspera, BigDecimal valor, StatusPedido statusPedido, TipoEntrega tipoEntrega, com.trabalho.ifood.domains.Cliente Cliente, com.trabalho.ifood.domains.Entregador Entregador, com.trabalho.ifood.domains.Estabelecimento estabelecimento, com.trabalho.ifood.domains.Produto produto) {
        this.id = id;
        this.descricaoPedido = descricaoPedido;
        this.tempoEspera = tempoEspera;
        this.valor = valor;
        this.tipoEntrega = tipoEntrega;
        this.statusPedido = statusPedido;
        cliente = Cliente;
        entregador = Entregador;
        Estabelecimento = estabelecimento;
        Produto = produto;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(@NotNull @NotBlank String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public @NotNull @NotBlank String getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(@NotNull @NotBlank String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public TipoEntrega getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(TipoEntrega tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public com.trabalho.ifood.domains.Cliente getCliente() {
        return cliente;
    }

    public void setCliente(com.trabalho.ifood.domains.Cliente Cliente) {
        cliente = Cliente;
    }

    public com.trabalho.ifood.domains.Entregador getEntregador() {
        return entregador;
    }

    public void setEntregador(com.trabalho.ifood.domains.Entregador Entregador) {
        entregador = Entregador;
    }

    public com.trabalho.ifood.domains.Estabelecimento getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(com.trabalho.ifood.domains.Estabelecimento estabelecimento) {
        Estabelecimento = estabelecimento;
    }

    public com.trabalho.ifood.domains.Produto getProduto() {
        return Produto;
    }

    public void setProduto(com.trabalho.ifood.domains.Produto produto) {
        Produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
