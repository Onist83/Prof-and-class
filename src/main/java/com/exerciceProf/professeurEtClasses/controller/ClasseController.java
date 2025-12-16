package com.exerciceProf.professeurEtClasses.controller;

import com.exerciceProf.professeurEtClasses.model.Classe;
import com.exerciceProf.professeurEtClasses.model.Professeur;
import com.exerciceProf.professeurEtClasses.service.ClasseService;
import com.exerciceProf.professeurEtClasses.service.ProfesseurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classe")
public class ClasseController {

    private ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping("/")
    public String getClasseIndex(Model model) {
        model.addAttribute("listClasses", classeService.getListclasses());
        return "/classes/index";
    }

    @GetMapping("/form")
    public String getnouvelleClasse(Model model) {
        model.addAttribute("classe", new Classe());
        return "/classes/form";
    }

    @PostMapping
    public String ajouterClasse(@ModelAttribute Classe c, Model model) {
        classeService.ajouterClasse(c);
        return "redirect:/classe/";
    }

    @GetMapping("/{id}")
    public Classe getClasseById(
            @PathVariable Long id
    ) {
        try {
            return classeService.getClasseById(id);
        } catch (IllegalAccessException e) {
            System.out.println("La Classe avec l'id " + id + " n'existe pas'");
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/modifier")
    public String getModifierClasse(Model model, @PathVariable Long id) throws IllegalAccessException {
        model.addAttribute("classe", classeService.getClasseById(id));
        return "classes/form";
    }

    @PostMapping("/{id}/modifier")
    public String modifierClasse(@ModelAttribute Classe c, Model model) {
        classeService.modifierClasse(c);
        return "redirect:/classe/";
    }

    @GetMapping("/{id}/supprimer")
    public String supprimerClasse(
            @PathVariable Long id
    ) {
        classeService.supprimerClasse(id);
        return "redirect:/classe/";
    }
}
