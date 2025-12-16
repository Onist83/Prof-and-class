package com.exerciceProf.professeurEtClasses.repository;

import com.exerciceProf.professeurEtClasses.model.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
