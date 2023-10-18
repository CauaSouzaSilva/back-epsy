package com.example.tbl_clientes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tbl_clientes.model.DTOs.PostoDTO;
import com.example.tbl_clientes.model.entities.Posto;
import com.example.tbl_clientes.model.services.PostoService;

@RestController
@RequestMapping(value = { "/api/rede/posto/", "/api/posto" })
public class PostoController {

    @Autowired
    private PostoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Posto> getAllPosto() {
        return service.findAllPostos();
    }

    @GetMapping(path = "/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Posto> findAllLike(@PathVariable String id) {
        return service.findAllByIdOrCnpj(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Posto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Posto createPosto(@RequestBody PostoDTO dto) {
        return service.createPosto(dto);
    }

}
