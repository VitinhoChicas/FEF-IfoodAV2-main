package com.trabalho.ifood.domains.enums;

public enum StatusPedido {

    PENDENTE(1, "PENDENTE"), EM_TRANSITO(2, "EM TRANSITO"), ENTREGUE(3, "ENTREGUE");
    private Integer id;
    private String descricao;

    StatusPedido(Integer id,String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static StatusPedido toEnum(Integer id){
        if (id==null) return null;
        for (StatusPedido c : StatusPedido.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Status do Pedido inválida");
    }
}