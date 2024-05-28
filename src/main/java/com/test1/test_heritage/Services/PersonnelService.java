package com.test1.test_heritage.Services;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.test1.test_heritage.Modules.Personnel;
import com.test1.test_heritage.Repositories.PersonnelRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PersonnelService {
    private PersonnelRepository personnelRepository;
    
    
    public PersonnelService(PersonnelRepository personnelRepository){
        this.personnelRepository=personnelRepository;
    }

    @Transactional
    public Personnel savPersonnel(Personnel personnel){
        return personnelRepository.save(personnel);
    }

    @Transactional
    public void deletePersonnel(Long id){
        personnelRepository.deleteById(id);
    }

    @Transactional
    public void updatePersonnel(Long id, Personnel personnel) {
        Optional<Personnel> optionalPersonnel = personnelRepository.findById(id);
        if (optionalPersonnel.isPresent()) {
            Personnel personnel1 = optionalPersonnel.get();
            personnel1.setFirstname(personnel.getFirstname());
            personnel1.setLastname(personnel.getLastname());
            personnel1.setSalaire(personnel.getSalaire());
            personnel1.setEmail(personnel.getEmail());
            personnel1.setPassword(personnel.getPassword());
            personnelRepository.save(personnel1);
        } else {
            throw new EntityNotFoundException("Incident not found.");
        }
    }
}
