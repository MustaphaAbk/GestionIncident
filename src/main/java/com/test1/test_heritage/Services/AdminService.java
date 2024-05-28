package com.test1.test_heritage.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.test1.test_heritage.Modules.admin;
import com.test1.test_heritage.Repositories.AdminRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;


@Service
public class AdminService {
    
    
    private AdminRepository adminRepository;
    
    
    public AdminService(AdminRepository adminRepository){
        
        this.adminRepository=adminRepository;
    }

    @Transactional
    public admin savAdmin(admin admin){
        return adminRepository.save(admin);
    }

    @Transactional
    public void deleteAdmin(Long id){
        adminRepository.deleteById(id);
    }

    @Transactional
    public void updateAdmin(Long id, admin admin) {
        Optional<admin> optionaladmin = adminRepository.findById(id);
        if (optionaladmin.isPresent()) {
            admin admin1 = optionaladmin.get();
            admin1.setFirstname(admin.getFirstname());
            admin1.setLastname(admin.getLastname());
            admin1.setSalaire(admin.getSalaire());
            admin1.setEmail(admin.getEmail());
            admin1.setPassword(admin.getPassword());
            adminRepository.save(admin1);
        } else {
            throw new EntityNotFoundException("Incident not found.");
        }
    }
    
}
