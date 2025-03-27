package com.trabalho.ifood.domains.dtos;

import com.trabalho.ifood.domains.GrupoProduto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GrupoProdutoDTO {
    private int id;

    @NotNull(message = "O campo descrição não pode estar vazio")
    @NotBlank(message = "O campo descrição não pode estar vazio")
    private String descricao;
    private int satus;

    public GrupoProdutoDTO() {
    }

    public GrupoProdutoDTO(GrupoProduto grupoProduto) {
        this.id = grupoProduto.getId();
        this.descricao = grupoProduto.getDescricao();
        this.satus = grupoProduto.getStatus().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotNull(message = "O campo descrição não pode estar vazio") @NotBlank(message = "O campo descrição não pode estar vazio") String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NotNull(message = "O campo descrição não pode estar vazio") @NotBlank(message = "O campo descrição não pode estar vazio") String descricao) {
        this.descricao = descricao;
    }

    public int getSatus() {
        return satus;
    }

    public void setSatus(int satus) {
        this.satus = satus;
    }
}
