package com.trabalho.ifood.resources;

import com.trabalho.ifood.domains.Pedido;
import com.trabalho.ifood.domains.dtos.PedidoDTO;
import com.trabalho.ifood.services.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return ResponseEntity.ok().body(pedidoService.findAll());

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable UUID id){
        Pedido obj = this.pedidoService.findbyId(id);
        return ResponseEntity.ok().body(new PedidoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PedidoDTO> create(@Valid @RequestBody PedidoDTO dto){
        Pedido Pedido = pedidoService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(Pedido.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> update(@PathVariable UUID id, @Valid @RequestBody PedidoDTO objDto){
        Pedido Obj = pedidoService.update(id, objDto);
        return ResponseEntity.ok().body(new PedidoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PedidoDTO> delete(@PathVariable UUID id){
        pedidoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}