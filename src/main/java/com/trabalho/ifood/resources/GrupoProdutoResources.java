package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.GrupoProduto;
import com.trabalho.ifood.domains.dtos.GrupoProdutoDTO;
import com.trabalho.ifood.services.GrupoProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/grupoproduto")
@Tag(name = "Grupo de Produtos", description = "API para gerenciamento de grupo de produtos")
public class GrupoProdutoResources {

    @Autowired
    private GrupoProdutoService grupoProdutoService;

    @GetMapping
    @Operation(summary = "Listar todos os grupos de produtos", description = "Retorna uma lista com todos os grupos de produtos cadastrados")
    public ResponseEntity<List<GrupoProdutoDTO>> findAll(){
        return ResponseEntity.ok(grupoProdutoService.findAll());
    }


    @GetMapping(value = "/{id}")
    @Operation(summary = "Busca o grupo de produto por id", description = "Realiza a busca de um grupo de produto cadastrado por id")
    public ResponseEntity<GrupoProdutoDTO> findById(@PathVariable Integer id){
        GrupoProduto obj = this.grupoProdutoService.findbyId(id);
        return ResponseEntity.ok().body(new GrupoProdutoDTO(obj));
    }
}