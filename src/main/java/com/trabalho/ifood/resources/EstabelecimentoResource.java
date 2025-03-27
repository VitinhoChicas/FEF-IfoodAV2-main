package com.trabalho.ifood.resources;


import com.trabalho.ifood.domains.Estabelecimento;
import com.trabalho.ifood.domains.dtos.EstabelecimentoDTO;
import com.trabalho.ifood.services.EstabelecimentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/estabelecimento")
public class EstabelecimentoResource {

    @Autowired
    private EstabelecimentoService EstabelecimentoService;

    @GetMapping
    public ResponseEntity<List<EstabelecimentoDTO>> findAll(){
        return ResponseEntity.ok().body(EstabelecimentoService.findAll());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> findById(@PathVariable Integer id){
        Estabelecimento obj = this.EstabelecimentoService.findbyId(id);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }
    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<EstabelecimentoDTO> findByCnpj(@PathVariable String cnpj) {
        Estabelecimento obj = this.EstabelecimentoService.findbyCnpj(cnpj);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<EstabelecimentoDTO> create(@Valid @RequestBody EstabelecimentoDTO dto){
        Estabelecimento Estabelecimento = EstabelecimentoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Estabelecimento.getIdEstab()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> update(@PathVariable Integer id, @Valid @RequestBody EstabelecimentoDTO objDto){
        Estabelecimento Obj = EstabelecimentoService.update(id, objDto);
        return ResponseEntity.ok().body(new EstabelecimentoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EstabelecimentoDTO> delete(@PathVariable Integer id){
        EstabelecimentoService.delete(id);
        return  ResponseEntity.noContent().build();
    }

}

