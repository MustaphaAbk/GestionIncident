package com.test1.test_heritage.Modules;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class etudiant extends personne{
    
    private String filliere;
    
}
