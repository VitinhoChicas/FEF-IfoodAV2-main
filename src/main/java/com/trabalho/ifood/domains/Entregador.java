package com.trabalho.ifood.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.domains.enums.TipoPessoa;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "Entregador")
public class Entregador extends Pessoa{
    @JsonIgnore
    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos = new ArrayList<>();

    public Entregador(Long idPessoa, String nome, String endereco, String telefone, String cpf) {
        super(idPessoa, nome, endereco, telefone, cpf);
        addTipoPessoa(TipoPessoa.ENTREGADOR);
    }

    public Entregador(EntregadorDTO dto){
        this.idPessoa = dto.getId();
        this.nome = dto.getNome();
        this.endereco = dto.getEndereco();
        this.telefone = dto.getTelefone();
        this.cpf = dto.getCpf();
        this.tipoPessoa = dto.getTipoPessoa().stream()
                .map(x -> x.getId()).collect(Collectors.toSet());
        addTipoPessoa(TipoPessoa.ENTREGADOR);
    }

    public Entregador(){
        super();
        addTipoPessoa(TipoPessoa.ENTREGADOR);
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
