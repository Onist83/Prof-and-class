package com.exerciceProf.professeurEtClasses.service;

import com.exerciceProf.professeurEtClasses.model.Professeur;
import com.exerciceProf.professeurEtClasses.repository.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesseurService {
    private ProfesseurRepository professeurRepository;
    private List<Professeur> listProfesseurs = new ArrayList<>();

    public ProfesseurService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public Professeur getProfesseurById(Long id) throws IllegalAccessException {
        return professeurRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalAccessException("Le Professeur avec l'Id " + id + " n'existe pas")
                );
    }

    //    New Prof
    public void nouveauProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    //    Modifier Prof
    public void modifierProfesseur(Professeur modifier) {
        try {
            getProfesseurById(modifier.getId());
            professeurRepository.save(modifier);
        } catch (IllegalCallerException | IllegalAccessException e) {
            System.out.println("Le Professeur avec l'Id " + modifier.getId() + " n'existe pas");
            throw new RuntimeException(e);
        }
    }

    public List<Professeur> getListprofesseurs() {
        return this.professeurRepository.findAll();
    }

    //    Ajouter Professeur
    public void ajouterProfesseur(Professeur professeur) {
        professeurRepository.save(professeur);
    }

    //    Supprimer Prof
    public void supprimerProfesseur(Long id) {
        professeurRepository.deleteById(id);
    }
}
