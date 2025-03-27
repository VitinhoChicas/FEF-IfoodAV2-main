package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.Produto;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.domains.dtos.ProdutoDTO;
import com.trabalho.ifood.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResources {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        public ResponseEntity<List<ProdutoDTO>> findAll(){
                return ResponseEntity.ok().body(produtoService.findAll());
        }

        @GetMapping(value = "/{id}")
        public ResponseEntity<ProdutoDTO> findbyId(@PathVariable Long id){
                Produto obj = this.produtoService.findbyId(id);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }

        @GetMapping(value = "/codigobarra/{codigoBarra}")
        public ResponseEntity<ProdutoDTO> findById(@PathVariable String codigoBarra){
                Produto obj = this.produtoService.findbycodigoBarra(codigoBarra);
                return ResponseEntity.ok().body(new ProdutoDTO(obj));
        }

        @PostMapping
        public ResponseEntity<ProdutoDTO> create(@Valid @RequestBody ProdutoDTO dto){
                Produto Produto = produtoService.create(dto);
                URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                        .buildAndExpand(Produto.getIdProduto()).toUri();
                return ResponseEntity.created(uri).build();
        }

        @PutMapping(value = "/{id}")
        public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO objDto){
                Produto Obj = produtoService.update(id, objDto);
                return ResponseEntity.ok().body(new ProdutoDTO(Obj));
        }

        @DeleteMapping(value = "/{id}")
        public ResponseEntity<ProdutoDTO> delete(@PathVariable Long id){
                produtoService.delete(id);
                return  ResponseEntity.noContent().build();
        }

}