package com.lucaskato.lab09.controllers;

import com.lucaskato.lab09.models.Professor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    private List<Professor> professores = new ArrayList<>();

    @GetMapping
    public List<Professor> listarProfessores() {
        return professores;
    }

    @PostMapping
    public Professor adicionarProfessor(@RequestBody Professor professor) {
        professores.add(professor);
        return professor;
    }

    @GetMapping("/{id}")
    public Professor buscarProfessor(@PathVariable long id) {
        return professores.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void removerProfessor(@PathVariable long id) {
        professores.removeIf(p -> p.getId() == id);
    }
}
