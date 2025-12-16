package com.exerciceProf.professeurEtClasses.model;

import jakarta.persistence.*;

@Entity
public class Classe {
    @Id
    @GeneratedValue
    private Long id;

    private String nom; //Terminal A
    private String niveau; // Seconde, Premiere
    private String matiere; // Math
    private int eleves; //Nb eleves


    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Professeur professeur;

    public Classe() {
    }

    public Classe(String nom, String niveau, String matiere, int eleves, Professeur professeur) {
        this.nom = nom;
        this.niveau = niveau;
        this.matiere = matiere;
        this.eleves = eleves;
        this.professeur = professeur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public int getEleves() {
        return eleves;
    }

    public void setEleves(int eleves) {
        this.eleves = eleves;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
}
