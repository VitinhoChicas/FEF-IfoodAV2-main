package com.trabalho.ifood.services;


import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.Produto;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.domains.dtos.ProdutoDTO;
import com.trabalho.ifood.repositories.ProdutoRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepo;

    public List<ProdutoDTO> findAll(){
        return produtoRepo.findAll().stream()
                .map(obj -> new ProdutoDTO(obj))
                .collect(Collectors.toList());
    }

    public Produto findbyId(Long id){
        Optional<Produto> obj = produtoRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Produto não encontrado! Id: " + id));
    }

    public Produto findbycodigoBarra(String codigoBarra){
        Optional<Produto> obj = produtoRepo.findByCodigoBarra(codigoBarra);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Codigo de barras não encontrado! Codigo de barras: " + codigoBarra));
    }

    public Produto create(ProdutoDTO dto){
        dto.setIdProduto(null);
        Produto obj = new Produto(dto);
        return produtoRepo.save(obj);
    }

    public Produto update(Long id, ProdutoDTO objDto){
        objDto.setIdProduto(id);
        Produto oldObj = findbyId(id);
        oldObj = new Produto(objDto);
        return produtoRepo.save(oldObj);
    }

    public void delete(Long id){
        Produto obj = findbyId(id);
        if (obj.getPedidos().size()>0){
            throw new DataIntegrityViolationException("Produto não pode ser deletado, pois tem um pedido vinculado ");
        }
        produtoRepo.deleteById(id);
    }

}