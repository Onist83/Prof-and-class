package com.exerciceProf.professeurEtClasses.service;

import com.exerciceProf.professeurEtClasses.model.Classe;
import com.exerciceProf.professeurEtClasses.model.Professeur;
import com.exerciceProf.professeurEtClasses.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClasseService {
    private ClasseRepository classeRepository;
    private List<Classe> listClasses = new ArrayList<>();

    public Classe getClasseById(Long id) throws IllegalAccessException {
        return classeRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalAccessException("La Classe avec l'Id " + id + " n'existe pas")
                );
    }

    public List<Classe> getListclasses() {
        return this.classeRepository.findAll();
    }

    //    Ajouter Classe
    public void ajouterClasse(Classe c) {
        classeRepository.save(c);
    }

    //    Modifier Classe
    public void modifierClasse(Classe modifier) {
        try {
            getClasseById(modifier.getId());
            classeRepository.save(modifier);
        } catch (IllegalCallerException | IllegalAccessException e) {
            System.out.println("La Classe avec l'Id " + modifier.getId() + " n'existe pas");
            throw new RuntimeException(e);
        }


    }

    //    Supprimer Classe
    public void supprimerClasse(Long id) {
        classeRepository.deleteById(id);
    }
}
