package com.example.tbl_clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tbl_clientes.model.entities.Posto;
import com.example.tbl_clientes.model.repository.PostoRepository;

@RestController
@RequestMapping(value = { "/api/rede/posto/", "/api/posto" })
public class PostoController {

    @Autowired
    private PostoRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Posto> getAllPosto() {
        return repository.findAll();
    }

}
