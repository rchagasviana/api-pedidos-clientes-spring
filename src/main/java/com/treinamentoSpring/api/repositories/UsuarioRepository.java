package com.treinamentoSpring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamentoSpring.api.entidades.UsuarioEntidade;

@Repository 
public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, Long> {

}
