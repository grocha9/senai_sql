package com.escola.senai.Controll;

import com.escola.senai.Models.Professor;
import com.escola.senai.Service.ProfessorService;
import com.escola.senai.Service.ProfessorService;
import jakarta.persistence.PostUpdate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("professor")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> buscarProfessor(){
        return professorService.buscarTodosProfessores();
    }


    @PostMapping
    public Professor salvar(@RequestBody Professor professor){
        return professorService.salvarNovoProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessores(@PathVariable Long id,@RequestBody Professor novoProfessor){
        Professor verificaProfessor = professorService.buscarProfessorId(id);
     if (verificaProfessor==null) return null;

     verificaProfessor.setNome(novoProfessor.getNome());
     verificaProfessor.setEmail(novoProfessor.getEmail());
     verificaProfessor.setTelefone(novoProfessor.getTelefone());
     return professorService.salvarNovoProfessor(verificaProfessor);
    }


    @GetMapping("/{id}")
    public Professor buscarProfessorId(@PathVariable Long id){
        return professorService.buscarProfessorId(id);
    }


    @DeleteMapping("/{id}")
    public void excluirProfessor(@PathVariable Long id){
        professorService.deletarProfessor(id);
    }




}

