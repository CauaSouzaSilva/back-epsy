package com.example.tbl_clientes.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tbl_clientes.model.entities.Posto;
import com.example.tbl_clientes.model.repository.PostoRepository;

@Service
public class PostoService {

    @Autowired
    private PostoRepository repository;

    public List<Posto> findAllPostos() {
        return repository.findAll();
    }

    public List<Posto> findAllByIdOrCnpj(String idCnpj) {
        return repository.findAllByLikeIdOrLikeCnpj(idCnpj, idCnpj);
    }

}
