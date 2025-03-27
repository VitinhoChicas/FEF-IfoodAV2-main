package com.trabalho.ifood.domains.enums;


public enum TipoEntrega {

    RETIRADA(1, "RETIRADA"), ENTREGA(2, "ENTREGA");
    private Integer id;
    private String descricao;

    TipoEntrega(Integer id,String descricao) {
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

    public static TipoEntrega toEnum(Integer id){
        if (id==null) return null;
        for (TipoEntrega c : TipoEntrega.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Tipo de entrega inválida");
    }
}