package com.garage.gestionGarage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/technicien")
public class TechnicienController {
    @Autowired
    private TechnicienRepository technicienRepository;
    @PostMapping
    public String AjouterTechnicien(@RequestBody Technicien technicien) {
    	technicienRepository.save(technicien);
    	return "Technicien Enregistrer avec succes"+technicien.getNom();
    }
    @GetMapping
    public List<Technicien> afficherTechnicien(){
    	return technicienRepository.findAll();
    }
    @PutMapping("/{id}")
    public Technicien ModifierTechnicien(@PathVariable Long id,@RequestBody Technicien technicienModifier) {
    	return technicienRepository.findById(id).map(t ->{
    		t.setNom(technicienModifier.getNom());
    		t.setPostNom(technicienModifier.getPostNom());
    		t.setPrenom(technicienModifier.getPrenom());
    		t.setAge(technicienModifier.getAge());
    		t.setRole(technicienModifier.getRole());
    		return technicienRepository.save(t);
    	}).orElseThrow(()-> new RuntimeException("Technicien Non Trouver"));
    }
    
}
