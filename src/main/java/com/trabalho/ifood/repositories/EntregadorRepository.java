package com.trabalho.ifood.repositories;

import com.trabalho.ifood.domains.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
    Optional<Entregador> findByCpf(String cpf);

}
