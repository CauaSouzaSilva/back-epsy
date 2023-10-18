package com.example.tbl_clientes.model.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tbl_clientes.model.entities.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long> {

    @Query("SELECT p FROM Posto p WHERE p.nomePosto LIKE :nome")
    List<Posto> findAllLikeName(@Param("nome")String nome, Pageable pageable);

    @Query("SELECT p FROM Posto p WHERE p.cnpjPosto LIKE :cnpj")
    List<Posto> findAllLikeCnpj(@Param("cnpj") String cnpj, Pageable pageable);
}
