package com.example.tbl_clientes.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tbl_clientes.exceptions.ResourceNotFoundException;
import com.example.tbl_clientes.model.entities.Posto;
import com.example.tbl_clientes.model.repository.PostoRepository;

@Service
public class PostoService {

    @Autowired
    private PostoRepository repository;

    public List<Posto> findAllPostos() {
        return repository.findAll();
    }

    public Posto findAllByIdOrCnpj(String id) {
        List<Posto> postos = new ArrayList<>();
        try {
            Long idPosto = Long.parseLong(id);
            postos.add(repository.findById(idPosto).orElseThrow((() -> new ResourceNotFoundException("Posto não encontrado para este 'id'"))));
        } catch (NumberFormatException e) {
            // TODO: handle exception
        }
        return null;
    }

}
