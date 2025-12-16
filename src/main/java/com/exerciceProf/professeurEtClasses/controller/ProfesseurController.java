package com.exerciceProf.professeurEtClasses.controller;

import com.exerciceProf.professeurEtClasses.model.Professeur;
import com.exerciceProf.professeurEtClasses.service.ProfesseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/professeur")
public class ProfesseurController {

    private ProfesseurService professeurService;

    public ProfesseurController(ProfesseurService professeurService) {
        this.professeurService = professeurService;
    }

    @GetMapping("/")
    public String getProfesseurIndex(Model model) {
        model.addAttribute("listProfesseurs", professeurService.getListprofesseurs());
        return "/professeurs/index";
    }

    @GetMapping("/form")
    public String getnouveauProfesseur(Model model) {
        model.addAttribute("professeur", new Professeur());
        return "/professeurs/form";
    }

    @PostMapping("ajouter-professeur")
    public String ajouterProfesseur(@ModelAttribute Professeur p, Model model) {
        professeurService.ajouterProfesseur(p);
        return "redirect:/professeur/";
    }

    @GetMapping("/{id}")
    public Professeur getProfesseurById(
            @PathVariable Long id
    ) {
        try {
            return professeurService.getProfesseurById(id);
        } catch (IllegalAccessException e) {
            System.out.println("Le Professseur avec l'id " + id + " n'existe pas'");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/modifier")
    public String getModifierProfesseur(Model model, @PathVariable Long id) throws IllegalAccessException {
        model.addAttribute("professeur", professeurService.getProfesseurById(id));
        return "/professeurs/form";
    }

    @PostMapping("/{id}/modifier")
    public String modifierProfesseur(@ModelAttribute Professeur p, Model model) {
        professeurService.modifierProfesseur(p);
        return "redirect:/professeur/";
    }

    @GetMapping("/{id}/supprimer")
    public String supprimerProfesseur(
            @PathVariable Long id
    ) {
        professeurService.supprimerProfesseur(id);
        return "redirect:/professeur/";
    }

    @GetMapping("/{id}/detail")
    public String getDetailProfesseur(Model model, @PathVariable Long id) throws IllegalAccessException {
        model.addAttribute("professeur", professeurService.getProfesseurById(id));
        return "/professeurs/detail";
    }
}
