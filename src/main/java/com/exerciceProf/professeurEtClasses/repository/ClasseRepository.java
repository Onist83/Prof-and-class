package com.exerciceProf.professeurEtClasses.repository;

import com.exerciceProf.professeurEtClasses.model.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
