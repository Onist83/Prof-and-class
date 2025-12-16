package com.exerciceProf.professeurEtClasses;

import com.exerciceProf.professeurEtClasses.model.Classe;
import com.exerciceProf.professeurEtClasses.model.Professeur;
import com.exerciceProf.professeurEtClasses.repository.ClasseRepository;
import com.exerciceProf.professeurEtClasses.repository.ProfesseurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfesseurEtClassesApplication {
    private ClasseRepository classeRepository;
    private ProfesseurRepository professeurRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProfesseurEtClassesApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ClasseRepository classeRepository, ProfesseurRepository professeurRepository) {
        return args -> {
            professeurRepository.save(new Professeur("Durant", "Jean", "j.durant@gmail.com"));
            professeurRepository.save(new Professeur("Durand", "Pierre", "p.durand@gmail.com"));
            professeurRepository.save(new Professeur("Dupond", "Leo", "l.dupond@gmail.com"));
            professeurRepository.save(new Professeur("Dupont", "Matthieu", "m.dupont@gmail.com"));
            professeurRepository.save(new Professeur("Duranne", "Fabien", "f.duranne@gmail.com"));

            Professeur professeur1 = professeurRepository.findById(1L).get();
            Professeur professeur2 = professeurRepository.findById(2L).get();
            Professeur professeur3 = professeurRepository.findById(3L).get();
            Professeur professeur4 = professeurRepository.findById(4L).get();
            Professeur professeur5 = professeurRepository.findById(5L).get();

            classeRepository.save(new Classe("Terminal A", "Terminal", "Mathematiques", 30, professeur1));
            classeRepository.save(new Classe("Terminal B", "Terminal", "Francais", 22, professeur1));
            classeRepository.save(new Classe("BTS C", "BTS", "Histoire", 18, professeur3));
            classeRepository.save(new Classe("BTS D", "BTS", "Geographie", 33, professeur2));
            classeRepository.save(new Classe("Seconde E", "Seconde", "Sport", 28, professeur4));
            classeRepository.save(new Classe("Premiere F", "Premiere", "Dessin", 15, professeur5));
        };
    }
}
