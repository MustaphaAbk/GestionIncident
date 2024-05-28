package com.test1.test_heritage.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test1.test_heritage.Modules.personne;

@Repository
public interface PersonneRepository extends JpaRepository<personne,Long>{
    
}
