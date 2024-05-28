package com.test1.test_heritage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test1.test_heritage.Modules.etudiant;

public interface etudiantRepository extends JpaRepository<etudiant,Long>{
    
}
