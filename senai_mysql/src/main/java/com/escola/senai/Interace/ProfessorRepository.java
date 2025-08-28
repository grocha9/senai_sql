package com.escola.senai.Interace;

import com.escola.senai.Models.Aluno;
import com.escola.senai.Models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
