package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.Pessoa;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.repositories.EntregadorRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntregadorService {
    @Autowired
    private EntregadorRepository EntregadorRepo;

    public List<EntregadorDTO> findAll(){
        //retorna uma lista de PessoaDTO
        return EntregadorRepo.findAll().stream().map(obj -> new EntregadorDTO(obj)).
                collect(Collectors.toList());

    }
    public Entregador findbyId(Long id){
        Optional<Entregador> obj = EntregadorRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Entregador não encontrado! Id: " + id));    }

    public Entregador findbyCpf(String cpf){
        Optional<Entregador> obj = EntregadorRepo.findByCpf(cpf);
        return obj.orElseThrow(()-> new ObjectNotFoundException("CPF não encontrado! Id: " + cpf));    }

    public Entregador create(EntregadorDTO dto){
        dto.setId(null);
        ValidaCPF(dto);
        Entregador obj = new Entregador(dto);
        return EntregadorRepo.save(obj);
    }

    public Entregador update(Long id, EntregadorDTO objDto){
        objDto.setId(id);
        Entregador oldObj = findbyId(id);
        ValidaCPF(objDto);
        oldObj = new Entregador(objDto);
        return EntregadorRepo.save(oldObj);
    }

    public void delete(Long id){
        Entregador obj = findbyId(id);
        if (obj.getPedidos().size()>0){
            throw new DataIntegrityViolationException("Entregador não pode ser deletado, pois tem um pedido vinculado ");
        }
        EntregadorRepo.deleteById(id);
    }

    private void ValidaCPF(EntregadorDTO objeto){
        Optional<Entregador> obj = EntregadorRepo.findByCpf(objeto.getCpf());
        if(!obj.isPresent() && obj.get().getIdPessoa()!= objeto.getId()){
            throw new org.springframework.dao.DataIntegrityViolationException("CPF Já cadastrado no sistema.");
        }
    }

}
