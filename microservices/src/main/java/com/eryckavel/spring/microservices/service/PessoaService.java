package com.eryckavel.spring.microservices.service;

import com.eryckavel.spring.microservices.model.Pessoa;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PessoaService {

    private final AtomicLong contar = new AtomicLong();

    public Pessoa buscar(String id){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(contar.incrementAndGet());
        pessoa.setPrimeironome("Eryck");
        pessoa.setUltimonome("Avelino");
        pessoa.setEndereco("Av E numero 26");
        pessoa.setGenero("Masculino");
        return pessoa;
    }

    public List<Pessoa> Listar(){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        for (int i = 0; i < 8; i++) {
            Pessoa pessoa = mockPessoa(i);
            pessoas.add(pessoa);
        }
        return pessoas;
    }

    private Pessoa mockPessoa(int i) {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(contar.incrementAndGet());
        pessoa.setPrimeironome("Nome da pessoa " + i);
        pessoa.setUltimonome("Ultimo nome da pessoa" + i);
        pessoa.setEndereco("Endereco da pessoa" + i);
        pessoa.setGenero("Genero da pessoa" + i);
        return pessoa;
    }

}
