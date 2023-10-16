package com.example.tbl_clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tbl_clientes.model.entities.Posto;

public interface PostoRepository extends JpaRepository<Posto, Long> {

    @Query("SELECT p FROM Posto p WHERE p.id LIKE '%?1%' OR p.cnpjPosto LIKE '%?2%'")
    List<Posto> findAllByLikeIdOrLikeCnpj(String idCnpj1, String idCnpj2);
}
