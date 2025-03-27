package com.trabalho.ifood.services;

import com.trabalho.ifood.domains.Cliente;
import com.trabalho.ifood.domains.Entregador;
import com.trabalho.ifood.domains.dtos.ClienteDTO;
import com.trabalho.ifood.domains.dtos.EntregadorDTO;
import com.trabalho.ifood.repositories.ClienteRepository;
import com.trabalho.ifood.services.exceptions.DataIntegrityViolationException;
import com.trabalho.ifood.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository ClienteRepo;

    public List<ClienteDTO> findAll(){
        //retorna uma lista de PessoaDTO
        return ClienteRepo.findAll().stream().map(obj -> new ClienteDTO(obj)).
                collect(Collectors.toList());

    }
    public Cliente findbyId(Long id){
        Optional<Cliente> obj = ClienteRepo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Cliente não encontrado! Id: " + id));    }

    public Cliente findbyCpf(String cpf){
        Optional<Cliente> obj = ClienteRepo.findByCpf(cpf);
        return obj.orElseThrow(()-> new ObjectNotFoundException("CPF não encontrado! Id: " + cpf));    }

    public Cliente create(ClienteDTO dto){
        dto.setId(null);
        ValidaCPF(dto);
        Cliente obj = new Cliente(dto);
        return ClienteRepo.save(obj);
    }

    public Cliente update(Long id, ClienteDTO objDto){
        objDto.setId(id);
        Cliente oldObj = findbyId(id);
        ValidaCPF(objDto);
        oldObj = new Cliente(objDto);
        return ClienteRepo.save(oldObj);
    }

    public void delete(Long id){
        Cliente obj = findbyId(id);
        if (obj.getPedidos().size()>0){
            throw new DataIntegrityViolationException("Cliente não pode ser deletado, pois tem um pedido vinculado ");
        }
        ClienteRepo.deleteById(id);
    }

    private void ValidaCPF(ClienteDTO objeto){
        Optional<Cliente> obj = ClienteRepo.findByCpf(objeto.getCpf());
        if(!obj.isPresent() && obj.get().getIdPessoa()!= objeto.getId()){
            throw new org.springframework.dao.DataIntegrityViolationException("CPF Já cadastrado no sistema.");
        }
    }

}

