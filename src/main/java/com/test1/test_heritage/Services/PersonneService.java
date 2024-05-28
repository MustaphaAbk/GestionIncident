package com.test1.test_heritage.Services;


import java.util.Optional;

import org.springframework.stereotype.Service;


import com.test1.test_heritage.Modules.personne;
import com.test1.test_heritage.Repositories.PersonneRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PersonneService {

    private PersonneRepository personneRepository;
    
    
    public PersonneService(PersonneRepository personneRepository){
        this.personneRepository=personneRepository;
    }


    @Transactional
    public personne savePersonne(personne personne){
        return personneRepository.save(personne);
    }

    @Transactional
    public void deletePersonne(Long id){
        personneRepository.deleteById(id);
    }

    @Transactional
    public void updatePersonne(Long id, personne personne) {
        Optional<personne> optionalPersonne = personneRepository.findById(id);
        if (optionalPersonne.isPresent()) {
            personne personne1 = optionalPersonne.get();
            personne1.setFirstname(personne.getFirstname());
            personne1.setLastname(personne.getLastname());
            personne1.setEmail(personne.getEmail());
            personne1.setPassword(personne.getPassword());
            personneRepository.save(personne1);
        } else {
            throw new EntityNotFoundException("Incident not found.");
        }
    }
}
