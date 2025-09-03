package com.escola.senai.Controll;

import com.escola.senai.Models.Aluno;
import com.escola.senai.Models.Professor;
import com.escola.senai.Service.AlunoService;
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
    
    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno novoAluno){
        Aluno verificaAluno = alunoService.buscarAlunosId(id);
        if (verificaAluno==null) return null;

        verificaAluno.setNome(novoAluno.getNome());
        verificaAluno.setEmail(novoAluno.getEmail());
        verificaAluno.setTelefone(novoAluno.getTelefone());
        return alunoService.salvarNovoAluno(verificaAluno);
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

