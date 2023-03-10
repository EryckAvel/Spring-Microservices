package com.eryckavel.spring.microservices.Controller;

import com.eryckavel.spring.microservices.model.Pessoa;
import com.eryckavel.spring.microservices.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @GetMapping
    public List<Pessoa> listarPessoas(){
        return service.Listar();
    }

    @GetMapping("/{id}")
    public Pessoa buscarId(@PathVariable("id") String id){
        return service.buscar(id);
    }



}
