package com.receitas.receitas_api.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {
    private static List<Receita> listaDeReceita = new ArrayList<>();

    private void criarReceitaFake() {
        Receita receitaFake = new Receita();
        receitaFake.setId(1L);
        receitaFake.setNome("Omelete");
        receitaFake.setIngredientes(List.of("2 ovos", "Leite", "Cebola"));
        receitaFake.setInstrucoes("Corta todos os ingredientes em pedaço e come!");

        listaDeReceita.add(receitaFake);
    }

    public ReceitaService() {
        criarReceitaFake();
    }

    public List<Receita> getAll() {
        return listaDeReceita;
    }

    public Receita getById(Long id) {
        return listaDeReceita.stream()
                .filter(receita -> receita.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ReceitaNotFoundException("Receita não encontrada com ID: " + id));
    }
}
