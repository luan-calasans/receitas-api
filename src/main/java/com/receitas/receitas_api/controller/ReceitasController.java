package com.receitas.receitas_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.receitas.receitas_api.model.Receita;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/receitas")
public class ReceitasController {
    private List<Receita> receitas = new ArrayList<>();

    // Método para listar receitas
    @GetMapping
    public ResponseEntity<List<Receita>> listarReceitas() {
        return ResponseEntity.ok(receitas);
    }

    // Método para criar uma nova receita
    @PostMapping
    public ResponseEntity<Receita> adicionarReceita(@RequestBody Receita receita) {
        receitas.add(receita);
        return ResponseEntity.ok(receita);
    }

    // Método para remover uma receita pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> removerReceita(@PathVariable Long id) {
        boolean removed = receitas.removeIf(receita -> receita.getId().equals(id));
        if (removed) {
            return ResponseEntity.ok("Receita removida com sucesso.");
        } else {
            return ResponseEntity.status(404).body("Receita não encontrada.");
        }
    }
}
