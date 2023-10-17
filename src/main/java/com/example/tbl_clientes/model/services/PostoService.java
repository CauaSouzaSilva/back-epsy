package com.example.tbl_clientes.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Posto> findAllByIdOrCnpj(String id) {
        List<Posto> postos = new ArrayList<>();
        try {
            Long idPosto = Long.parseLong(id);
            Optional<Posto> p = repository.findById(idPosto);
            if (p.isPresent()) postos.add(p.get());
        } catch (NumberFormatException e) {}

        id = ('%'+id+'%');

        postos.add(repository.findAllLikeName(id.toLowerCase(), Pageable.ofSize(4)).get(0));

        return postos;
    }

}
