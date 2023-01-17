package com.treina.recife.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treina.recife.model.Contado;

public interface ContatoService extends JpaRepository<Contado,Long> {
    

}
