package com.trabalho.ifood.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.ClienteDTO;
import com.trabalho.ifood.domains.enums.TipoPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa{
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(Long idPessoa, String nome, String endereco, String telefone, String cpf) {
        super(idPessoa, nome, endereco, telefone, cpf);
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Cliente(ClienteDTO dto){
        this.idPessoa = dto.getId();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.cpf = dto.getCpf();
        this.tipoPessoa = dto.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public Cliente(){
        super();
        addTipoPessoa(TipoPessoa.CLIENTE);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
