package com.receitas.receitas_api.model;

import java.util.List;
import java.util.Objects;

public class Receita {
    // CONTROL + . (CRIAR HASH CODE)
    private Long id;
    private String nome;
    private List<String> ingrediente;

    // Construtor
    public Receita(Long id, String nome, List<String> ingrediente) {
        this.id = id;
        this.nome = nome;
        this.ingrediente = ingrediente;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<String> getIngrediente() {
        return ingrediente;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIngrediente(List<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    // equals baseado somente no id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receita)) return false;
        Receita produto = (Receita) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
