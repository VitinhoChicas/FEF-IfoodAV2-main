package com.trabalho.ifood.domains.enums;

public enum TipoProduto {
    COMIDA(1, "COMIDA"), BEBIDA(2, "BEBIDA");
    private Integer id;
    private String descricao;

    TipoProduto(Integer id,String descricao) {
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

    public static TipoProduto toEnum(Integer id){
        if (id==null) return null;
        for (TipoProduto c : TipoProduto.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Tipo Produto inválido");
    }
}
