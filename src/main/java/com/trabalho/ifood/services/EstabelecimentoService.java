package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Estabelecimento;
import com.trabalho.ifood.domains.dtos.EstabelecimentoDTO;
import com.trabalho.ifood.repositories.EstabelecimentoRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository EstabelecimentoRepo;

    public List<EstabelecimentoDTO> findAll(){
        return EstabelecimentoRepo.findAll().stream().map(obj -> new EstabelecimentoDTO(obj)).
                collect(Collectors.toList());

    }
    public Estabelecimento findbyId (Integer id){
        Optional<Estabelecimento> obj = EstabelecimentoRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Estabelecimento não encontrado! Id: " + id));
    }
    public Estabelecimento findbyCnpj(String cnpj){
        Optional<Estabelecimento> obj = EstabelecimentoRepo.findByCnpj(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Estabelecimento não encontrado! CNPJ: " + cnpj));
    }

    public Estabelecimento create(EstabelecimentoDTO dto){
        dto.setIdEstab(null);
        Estabelecimento obj = new Estabelecimento(dto);
        return EstabelecimentoRepo.save(obj);
    }

    public Estabelecimento update(Integer id, EstabelecimentoDTO objDto){
        objDto.setIdEstab(id);
        Estabelecimento oldObj = findbyId(id);
        oldObj = new Estabelecimento(objDto);
        return EstabelecimentoRepo.save(oldObj);
    }

    public void delete(Integer id){
        Estabelecimento obj = findbyId(id);
        if (obj.getPedidos().size()>0){
            throw new DataIntegrityViolationException("Estabelecimento não pode ser deletado, pois tem um pedido vinculado ");
        }
        EstabelecimentoRepo.deleteById(id);
    }




}
