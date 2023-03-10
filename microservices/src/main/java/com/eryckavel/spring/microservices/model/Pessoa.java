package com.eryckavel.spring.microservices.model;

import java.io.Serializable;
import java.util.Objects;

public class Pessoa implements Serializable {

    private Long id;
    private String primeironome;
    private String ultimonome;
    private String endereco;
    private String genero;

    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimeironome() {
        return primeironome;
    }

    public void setPrimeironome(String primeironome) {
        this.primeironome = primeironome;
    }

    public String getUltimonome() {
        return ultimonome;
    }

    public void setUltimonome(String ultimonome) {
        this.ultimonome = ultimonome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(primeironome, pessoa.primeironome) && Objects.equals(ultimonome, pessoa.ultimonome) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(genero, pessoa.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, primeironome, ultimonome, endereco, genero);
    }
}
