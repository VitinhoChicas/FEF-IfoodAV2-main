package com.trabalho.ifood.domains.enums;

public enum TipoPessoa {
    CLIENTE(0, "CLIENTE"), ENTREGADOR(1, "ENTREGADOR");
    private Integer id;
    private String tipoPessoa;

    TipoPessoa(Integer id, String tipoPessoa){
    this.id = id;
    this.tipoPessoa = tipoPessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public static TipoPessoa toEnum(Integer id){
        if (id==null) return null;
        for (TipoPessoa c : TipoPessoa.values()){
            if (id.equals(c.getId())){
                return c;
            }
        }

        throw new IllegalArgumentException("Tipo de pessoa inválida");
    }

}
