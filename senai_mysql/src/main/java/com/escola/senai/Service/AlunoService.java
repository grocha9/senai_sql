package com.escola.senai.Service;

import com.escola.senai.Interace.AlunoRepository;
import com.escola.senai.Models.Aluno;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    private final AlunoRepository repository;


    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }


    public List<Aluno> buscarTodosAlunos() {
        return repository.findAll();
    }


    public Aluno salvarNovoAluno(Aluno aluno) {
      return repository.save(aluno);
    }

    public Aluno buscarAlunosId(Long id) {
        return repository.findById(id).orElse((null));
    }

    public void deletarAluno(long id){
        repository.deleteById(id);
    }



}
