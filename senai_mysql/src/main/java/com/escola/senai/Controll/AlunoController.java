package com.escola.senai.Controll;

import com.escola.senai.Interace.AlunoRepository;
import com.escola.senai.Models.Aluno;
import com.escola.senai.Service.AlunoService;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> buscarALunos(){
        return alunoService.buscarTodosAlunos();
    }


    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno){
        return alunoService.salvarNovoAluno(aluno);
    }

    @GetMapping("/{id}")
    public Aluno buscaAlunoId(@PathVariable Long id){
        return alunoService.buscarAlunosId(id);
    }


    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id){
        alunoService.deletarAluno(id);
    }




}

