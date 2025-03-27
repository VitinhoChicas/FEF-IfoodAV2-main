package com.trabalho.ifood.domains.enums;

public enum StatusProduto {
    ATIVO(1, "ATIVO"), INATIVO(2, "INATIVO");
    private Integer id;
    private String descricao;

    StatusProduto(Integer id,String descricao) {
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

    public static StatusProduto toEnum(Integer id){
        if (id==null) return null;
        for (StatusProduto c : StatusProduto.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Status do Produto inválida");
    }
}
