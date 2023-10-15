package com.example.tbl_clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tbl_clientes.model.entities.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long> {

}
