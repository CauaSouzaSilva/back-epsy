package com.example.tbl_clientes.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.tbl_clientes.exceptions.ObjectNullException;
import com.example.tbl_clientes.exceptions.ResourceNotFoundException;
import com.example.tbl_clientes.model.DTOs.PostoDTO;
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

        repository.findAllLikeName(id.toLowerCase(), Pageable.ofSize(4)).forEach(p -> {
            if(!postos.contains(p)) postos.add(p);
        });
        repository.findAllLikeCnpj(id, Pageable.ofSize(4)).forEach(p -> {
            if(!postos.contains(p)) postos.add(p);
        });

        return postos;
    }

    public Posto findById(Long id) {
        if (id.equals(null) || id <=-1) throw new ObjectNullException("Id invalido.");
        Posto posto = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nenhum posto encontrado para esse id"));
        if(isPostoValid(posto))
            throw new ResourceNotFoundException("Nenhum posto encontrado para esse id");
        return posto;
    }

    public Posto createPosto(PostoDTO dto) {
        Posto posto = repository.save(DTOtoPosto(dto));
        return posto;
    }

    private Boolean isPostoValid(Posto posto) {
        return posto == null || posto.getId().equals(null) || posto.getCnpjPosto().equals(null) || posto.getNomePosto().equals(null);
    }

    private Posto DTOtoPosto(PostoDTO dto) {
        if(dto.equals(null) || dto.cnpj().equals(null) || dto.cnpj().equals("") || dto.nome().equals(null) || dto.nome().equals(""))
            throw new ObjectNullException("Todos os campos devem ser preenchidos.");
        Posto posto = new Posto(dto.nome().toLowerCase(), dto.cnpj());
        return posto;
    }
}
