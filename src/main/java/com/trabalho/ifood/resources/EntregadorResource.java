package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.services.EntregadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/entregador")
public class EntregadorResource {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public ResponseEntity<List<EntregadorDTO>> findAll(){ return ResponseEntity.ok().body(entregadorService.findAll());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<EntregadorDTO> findById(@PathVariable Long id){
        Entregador obj = this.entregadorService.findbyId(id);
        return ResponseEntity.ok().body(new EntregadorDTO(obj));
    }

    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<EntregadorDTO> findById(@PathVariable String cpf){
        Entregador obj = this.entregadorService.findbyCpf(cpf);
        return ResponseEntity.ok().body(new EntregadorDTO(obj));
    }


    @PostMapping
    public ResponseEntity<EntregadorDTO> create(@Valid @RequestBody EntregadorDTO dto){
        Entregador Entregador = entregadorService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Entregador.getIdPessoa()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EntregadorDTO> update(@PathVariable Long id, @Valid @RequestBody EntregadorDTO objDto){
        Entregador Obj = entregadorService.update(id, objDto);
        return ResponseEntity.ok().body(new EntregadorDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<EntregadorDTO> delete(@PathVariable Long id){
        entregadorService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
