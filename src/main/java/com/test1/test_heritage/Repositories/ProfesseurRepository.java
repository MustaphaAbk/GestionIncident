package com.test1.test_heritage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test1.test_heritage.Modules.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long>{
    
}
