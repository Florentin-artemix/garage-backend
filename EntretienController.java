package com.garage.gestionGarage;

import java.time.LocalDate;
import java.util.ArrayList;
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
@RequestMapping("/api/entretien")
public class EntretienController {
    @Autowired
    EntretienRepository entretienRepository;
    @PostMapping
    public String ajouterEntretien(@RequestBody Entretien entretien) {
    	entretienRepository.save(entretien);
    	return "Entretien Enregistrer avec Succes Type: "+entretien.getTypeEntretien();
    }
    @GetMapping
    public List <EntretienDTO> afficherEntretien() {
    	List <Entretien>entretien=entretienRepository.findAll();
    	List <EntretienDTO>listDto= new ArrayList<>();
    	for(Entretien e: entretien) {
    		Long id=e.getId();
    		String nomTech=e.getTechnicien().getNom();
			String prenomTech=e.getTechnicien().getPrenom();
			String typeMachine=e.getMachine().getType();
			String modeleMachine=e.getMachine().getModele();
			LocalDate dateEn=e.getDateEntretien();
			String typeEn=e.getTypeEntretien();
			String descr=e.getDescription();
			listDto.add(new EntretienDTO(id,nomTech,prenomTech,typeMachine,modeleMachine,dateEn,typeEn,descr));
    	}
    	return listDto;
    }
    @PutMapping("/{id}")
    public String modifierEntretien(@PathVariable Long id,@RequestBody Entretien entretien) {
    	return entretienRepository.findById(id).map(e->{
    		e.setDateEntretien(entretien.getDateEntretien());
    		e.setDescription(entretien.getDescription());
    		e.setTypeEntretien(entretien.getTypeEntretien());
    		e.setMachine(entretien.getMachine());
    		e.setTechnicien(entretien.getTechnicien());
    		entretienRepository.save(e);
    		return "Entretien Modifier avec succès";
    	}).orElse(null);
    }
}
