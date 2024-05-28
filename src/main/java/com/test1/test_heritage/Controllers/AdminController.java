package com.test1.test_heritage.Controllers;

import com.test1.test_heritage.Modules.Personnel;
import com.test1.test_heritage.Modules.Professeur;
import com.test1.test_heritage.Modules.admin;
import com.test1.test_heritage.Modules.etudiant;
import com.test1.test_heritage.Modules.personne;
import com.test1.test_heritage.Repositories.AdminRepository;
import com.test1.test_heritage.Repositories.PersonneRepository;
import com.test1.test_heritage.Repositories.PersonnelRepository;
import com.test1.test_heritage.Repositories.ProfesseurRepository;
import com.test1.test_heritage.Repositories.etudiantRepository;
import com.test1.test_heritage.Services.AdminService;
import com.test1.test_heritage.Services.EtudiantService;
import com.test1.test_heritage.Services.PersonneService;
import com.test1.test_heritage.Services.PersonnelService;
import com.test1.test_heritage.Services.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class AdminController {

    private final PersonnelRepository personnelRepository;
    private final PersonneRepository personneRepository;
    private final ProfesseurRepository professeurRepository;
    private final etudiantRepository etudiantRepository;
    private final AdminRepository adminRepository;

    private final AdminService adminService;
    private final EtudiantService etudiantService;
    private final PersonneService personneService;
    private final PersonnelService personnelService;
    private final ProfesseurService professeurService;


    public AdminController(PersonnelRepository personnelRepository,PersonneRepository personneRepository,AdminService adminService,ProfesseurRepository professeurRepository,etudiantRepository etudiantRepository,EtudiantService etudiantService,ProfesseurService professeurService,PersonnelService personnelService,PersonneService personneService,AdminRepository adminRepository) {
        this.personnelRepository = personnelRepository;
        this.personneRepository = personneRepository;
        this.professeurRepository = professeurRepository;
        this.etudiantRepository = etudiantRepository;
        this.adminRepository = adminRepository;
        this.adminService = adminService;
        this.etudiantService = etudiantService;
        this.personneService = personneService;
        this.personnelService = personnelService;
        this.professeurService = professeurService;
    }
//personnel CRUD
    @GetMapping("/admin/personnel")
    public List<Personnel> getPersonnel() {
        return personnelRepository.findAll();
    }

    @PostMapping("/admin/newpersonnel")
    public ResponseEntity<Personnel> addPersonnel(@RequestBody Personnel personnel) {
        Personnel savePersonnel=personnelService.savPersonnel(personnel);
        return new ResponseEntity<>(savePersonnel, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/personnel/{id}")
    public ResponseEntity<Personnel> deletePersonnel(@PathVariable Long id){
        personneService.deletePersonne(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/updatepersonnel/{id}")
    public ResponseEntity<String> updatePersonnel(@PathVariable Long id,@RequestBody  Personnel newEtat){
        personnelService.updatePersonnel(id,newEtat);
        return ResponseEntity.ok("etat changed");
    }

//personne CRUD
    @GetMapping("/admin/personne")
    public List<personne> getPersonne() {
        return personneRepository.findAll();
    }
    
    @PostMapping("/admin/newpersonne")
    public ResponseEntity<personne> addPersonne(@RequestBody personne personne) {
        personne savePersonne=personneService.savePersonne(personne);
        return new ResponseEntity<>(savePersonne, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/personne/{id}")
    public ResponseEntity<personne> deletePersonne(@PathVariable Long id){
        personneService.deletePersonne(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/updatepersonne/{id}")
    public ResponseEntity<String> updatePersonne(@PathVariable Long id,@RequestBody  personne newEtat){
        personneService.updatePersonne(id,newEtat);
        return ResponseEntity.ok("etat changed");
    }
    
//professeur crud
    @GetMapping("/admin/professeur")
    public List<Professeur> getProfesseurs() {
        return professeurRepository.findAll();
    }
    
    @PostMapping("/admin/newprofesseur")
    public ResponseEntity<Professeur> addProf(@RequestBody Professeur professeur) {
        Professeur saveProfesseur=professeurService.savProfesseur(professeur);
        return new ResponseEntity<>(saveProfesseur, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/professeur/{id}")
    public ResponseEntity<Professeur> deleteProfesseur(@PathVariable Long id){
        professeurService.deleteProfesseur(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/updateprofesseur/{id}")
    public ResponseEntity<String> updateProfesseur(@PathVariable Long id,@RequestBody  Professeur newEtat){
        professeurService.updateprofesseur(id,newEtat);
        return ResponseEntity.ok("etat changed");
    }

//etudiant CRUD
    @GetMapping("/admin/etudiant")
    public List<etudiant> getEtudiants() {
        return etudiantRepository.findAll();
    }
    
    @PostMapping("/admin/newetudiant")
    public ResponseEntity<etudiant> addEtd(@RequestBody etudiant etudiant) {
        etudiant saveEtudiant=etudiantService.savetudiant(etudiant);
        return new ResponseEntity<>(saveEtudiant, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/admin/etudiant/{id}")
    public ResponseEntity<etudiant> deleteEtudiant(@PathVariable Long id){
        etudiantService.deleteEtudiant(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/updateetudiiant/{id}")
    public ResponseEntity<String> updateEtudiant(@PathVariable Long id,@RequestBody  etudiant newEtat){
        etudiantService.updateEtudiant(id,newEtat);
        return ResponseEntity.ok("etat changed");
    }

//admin CRUD
    @GetMapping("/admin/admins")
    public List<admin> getAdmins() {
        return adminRepository.findAll();
    }

    @PostMapping("/admin/newadmin")
    public ResponseEntity<admin> addAdmin(@RequestBody admin admin) {
        admin saveAdmin=adminService.savAdmin(admin);
        return new ResponseEntity<>(saveAdmin, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/admin/{id}")
    public ResponseEntity<admin> deleteAdmin(@PathVariable Long id){
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/admin/updateadmin/{id}")
    public ResponseEntity<String> updateAdmin(@PathVariable Long id,@RequestBody  admin newEtat){
        adminService.updateAdmin(id,newEtat);
        return ResponseEntity.ok("etat changed");
    }
}