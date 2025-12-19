package com.exerciceProf.professeurEtClasses.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acceuil")
public class AcceuilController {

    @GetMapping("/")
    public String getAcceuilIndex() {
        return "/acceuil/index";
    }
}
