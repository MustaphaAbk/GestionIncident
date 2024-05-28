package com.test1.test_heritage.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test1.test_heritage.Modules.Professeur;

import com.test1.test_heritage.Repositories.ProfesseurRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProfesseurService {
    private ProfesseurRepository professeurRepository;

    public ProfesseurService(ProfesseurRepository professeurRepository){
        this.professeurRepository=professeurRepository;
    }

    @Transactional
    public Professeur savProfesseur(Professeur professeur){
        return professeurRepository.save(professeur);
    }

    @Transactional
    public void deleteProfesseur(Long id){
        professeurRepository.deleteById(id);
    }

    @Transactional
    public void updateprofesseur(Long id, Professeur professeur) {
        Optional<Professeur> optionalprofesseur = professeurRepository.findById(id);
        if (optionalprofesseur.isPresent()) {
            Professeur professeur1 = optionalprofesseur.get();
            professeur1.setFirstname(professeur.getFirstname());
            professeur1.setLastname(professeur.getLastname());
            professeur1.setSalaire(professeur.getSalaire());
            professeur1.setDateEmbauche(professeur.getDateEmbauche());
            professeur1.setEmail(professeur.getEmail());
            professeur1.setPassword(professeur.getPassword());
            professeurRepository.save(professeur1);
        } else {
            throw new EntityNotFoundException("Incident not found.");
        }
    }
}
