package com.lucaskato.lab09.controllers;

import com.lucaskato.lab09.models.Disciplina;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    private List<Disciplina> disciplinas = new ArrayList<>();

    @GetMapping
    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }

    @PostMapping
    public Disciplina adicionarDisciplina(@RequestBody Disciplina disciplina) {
        disciplinas.add(disciplina);
        return disciplina;
    }

    @GetMapping("/{id}")
    public Disciplina buscarDisciplina(@PathVariable long id) {
        return disciplinas.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removerDisciplina(@PathVariable long id) {
        disciplinas.removeIf(d -> d.getId() == id);
    }
}
