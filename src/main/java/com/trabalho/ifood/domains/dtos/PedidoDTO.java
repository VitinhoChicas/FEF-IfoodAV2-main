package com.trabalho.ifood.domains.dtos;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.trabalho.ifood.domains.Pedido;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class PedidoDTO {

    private UUID id;

    @NotNull(message = "O campo descricaoPedido não pode ser nulo")
    @NotBlank (message = "O campo descricaoPedido não pode estar vazio")
    private String descricaoPedido;

    @NotNull(message = "O campo tempoEspera não pode ser nulo")
    @NotBlank (message = "O campo tempoEspera não pode estar vazio")
    private String tempoEspera;
    

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPedido = LocalDate.now();

    @NotNull (message = "O campo Valor de Compra não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    private int statusPedido;
    private int tipoEntrega;

    @NotNull(message = "O campo Cliente é requerido")
    private Long Cliente;

    @NotNull(message = "O campo Entregador é requerido")
    private Long Entregador;

    @NotNull(message = "O campo Estabelecimento é requerido")
    private int Estabelecimento;

    @NotNull(message = "O campo Produto é requerido")
    private Long Produto;

   private String nomeCliente;
   private String nomeEntregador;

    public PedidoDTO() {
    }

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.descricaoPedido = pedido.getDescricaoPedido();
        this.tempoEspera = pedido.getTempoEspera();
        this.dataPedido = pedido.getDataPedido();
        this.valor = pedido.getValor();
        this.statusPedido = pedido.getStatusPedido().getId();
        this.tipoEntrega = pedido.getTipoEntrega().getId();
        Cliente = pedido.getCliente().getIdPessoa();
        Entregador = pedido.getEntregador().getIdPessoa();
        Estabelecimento = pedido.getEstabelecimento().getIdEstab();
        Produto = pedido.getProduto().getIdProduto();
        this.nomeCliente = pedido.getCliente().getNome();
        this.nomeEntregador = pedido.getEntregador().getNome();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descricaoPedido não pode ser nulo") @NotBlank(message = "O campo descricaoPedido não pode estar vazio") String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(@NotNull(message = "O campo descricaoPedido não pode ser nulo") @NotBlank(message = "O campo descricaoPedido não pode estar vazio") String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public @NotNull(message = "O campo tempoEspera não pode ser nulo") @NotBlank(message = "O campo tempoEspera não pode estar vazio") String getTempoEspera() {
        return tempoEspera;
    }

    public void setTempoEspera(@NotNull(message = "O campo tempoEspera não pode ser nulo") @NotBlank(message = "O campo tempoEspera não pode estar vazio") String tempoEspera) {
        this.tempoEspera = tempoEspera;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public @NotNull(message = "O campo Valor de Compra não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "O campo Valor de Compra não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    public int getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(int statusPedido) {
        this.statusPedido = statusPedido;
    }

    public int getTipoEntrega() {
        return tipoEntrega;
    }

    public void setTipoEntrega(int tipoEntrega) {
        this.tipoEntrega = tipoEntrega;
    }

    public @NotNull(message = "O campo Cliente é requerido") Long getCliente() {
        return Cliente;
    }

    public void setCliente(@NotNull(message = "O campo Cliente é requerido") Long cliente) {
        Cliente = cliente;
    }

    public @NotNull(message = "O campo Entregador é requerido") Long getEntregador() {
        return Entregador;
    }

    public void setEntregador(@NotNull(message = "O campo Entregador é requerido") Long entregador) {
        Entregador = entregador;
    }

    @NotNull(message = "O campo Estabelecimento é requerido")
    public int getEstabelecimento() {
        return Estabelecimento;
    }

    public void setEstabelecimento(@NotNull(message = "O campo Estabelecimento é requerido") int estabelecimento) {
        Estabelecimento = estabelecimento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeEntregador() {
        return nomeEntregador;
    }

    public void setNomeEntregador(String nomeEntregador) {
        this.nomeEntregador = nomeEntregador;
    }

    public @NotNull(message = "O campo Produto é requerido") Long getProduto() {
        return Produto;
    }

    public void setProduto(@NotNull(message = "O campo Produto é requerido") Long produto) {
        Produto = produto;
    }
}

