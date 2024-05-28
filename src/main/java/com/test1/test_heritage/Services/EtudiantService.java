package com.test1.test_heritage.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.test1.test_heritage.Modules.etudiant;
import com.test1.test_heritage.Repositories.etudiantRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EtudiantService {
    private etudiantRepository etudiantRepository;

    public EtudiantService(etudiantRepository etudiantRepository){
        this.etudiantRepository=etudiantRepository;
    }

    @Transactional
    public etudiant savetudiant(etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }

    @Transactional
    public void deleteEtudiant(Long id){
        etudiantRepository.deleteById(id);
    }

    @Transactional
    public void updateEtudiant(Long id, etudiant etudiant) {
        Optional<etudiant> optionaletudiant = etudiantRepository.findById(id);
        if (optionaletudiant.isPresent()) {
            etudiant etudiant1 = optionaletudiant.get();
            etudiant1.setFirstname(etudiant.getFirstname());
            etudiant1.setLastname(etudiant.getLastname());
            etudiant1.setFilliere(etudiant.getFilliere());
            etudiant1.setEmail(etudiant.getEmail());
            etudiant1.setPassword(etudiant.getPassword());
            etudiantRepository.save(etudiant1);
        } else {
            throw new EntityNotFoundException("Incident not found.");
        }
    }
}
