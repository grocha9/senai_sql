package com.escola.senai.Service;

import com.escola.senai.Interace.AlunoRepository;
import com.escola.senai.Interace.ProfessorRepository;
import com.escola.senai.Models.Aluno;
import com.escola.senai.Models.Professor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorService {
    private final ProfessorRepository repository;


    public ProfessorService(ProfessorRepository repository) {
        this.repository = repository;
    }


    public List<Professor> buscarTodosProfessores() {
        return repository.findAll();
    }


    public Professor salvarNovoProfessor(Professor professor) {
      return repository.save(professor);
    }

    public Professor buscarProfessorId(Long id) {
        return repository.findById(id).orElse((null));
    }

    public void deletarProfessor(long id){
        repository.deleteById(id);
    }



}
