package com.trabalho.ifood.services;


import com.trabalho.ifood.domains.*;
import com.trabalho.ifood.domains.dtos.PedidoDTO;
import com.trabalho.ifood.domains.enums.StatusPedido;
import com.trabalho.ifood.domains.enums.TipoEntrega;
import com.trabalho.ifood.repositories.*;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository PedidoRepo;

    @Autowired
    private ClienteService ClienteService;

    @Autowired
    private EntregadorService EntregadorService;

    @Autowired
    private EstabelecimentoService EstabelecimentoService;

    @Autowired
    private ProdutoService ProdutoService;

    public List<PedidoDTO> findAll() {
        return PedidoRepo.findAll().stream().map(obj -> new PedidoDTO(obj)).
                collect(Collectors.toList());
    }

    public Pedido findbyId(UUID id) {
        Optional<Pedido> obj = PedidoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pedido não encontrado! Id: " + id));
    }

    private Pedido newPedido(PedidoDTO dto){
        Cliente cliente = ClienteService.findbyId(dto.getCliente());
        Entregador entregador = EntregadorService.findbyId(dto.getEntregador());
        Estabelecimento estabelecimento = EstabelecimentoService.findbyId(dto.getEstabelecimento());
        Produto produto = ProdutoService.findbyId(dto.getProduto());

        Pedido pedido = new Pedido();
        if (dto.getId() != null){
            pedido.setId(dto.getId());
        }

        pedido.setCliente(cliente);
        pedido.setEntregador(entregador);
        pedido.setStatusPedido(StatusPedido.toEnum(dto.getStatusPedido()));
        pedido.setTipoEntrega(TipoEntrega.toEnum(dto.getTipoEntrega()));
        pedido.setDataPedido(dto.getDataPedido());
        pedido.setDescricaoPedido(dto.getDescricaoPedido());
        pedido.setEstabelecimento(estabelecimento);
        pedido.setProduto(produto);
        pedido.setTempoEspera(dto.getTempoEspera());
        pedido.setValor(dto.getValor());
        return pedido;

    }

    public Pedido create(PedidoDTO dto) {
        return PedidoRepo.save(newPedido(dto));
    }

    public Pedido update(UUID id, PedidoDTO objDto){
        objDto.setId(id);
        Pedido oldObj = findbyId(id);
        oldObj = newPedido(objDto);
        return PedidoRepo.save(oldObj);
    }

    public void delete(UUID id){
        Pedido obj = findbyId(id);
        PedidoRepo.deleteById(id);
    }




}
