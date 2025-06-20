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
@RequestMapping("/api/intervention")
public class InterventionController {
	@Autowired
	InterventionRepository interventionRepository;
	@GetMapping
	public List<InterventionDTO>afficherIntervention(){
		return interventionRepository.findAll().stream().map(i ->{
			var id=i.getId();
			var nom=i.getTechnicien().getNom();
			var prenom=i.getTechnicien().getPrenom();
			var type=i.getMachine().getType();
			var modele=i.getMachine().getModele();
			var typeI=i.getTypeIntervention();
			var desc=i.getDescription();
			var km=i.getKmOuHeureMoteur();
			var photoI=i.getPhotoIntervention();
			var signat=i.getSignatures();
			var valid=i.isValidationChefGarage();
			var dto=new InterventionDTO(id,nom,prenom,type,modele,typeI,desc,
					km,photoI,signat,valid);
			return dto;
		}).toList();
	}
    @PostMapping
    public String ajouterIntervention(@RequestBody Intervention intervention) {
    	interventionRepository.save(intervention);
    	return "intervention Enregistrer avec succes";
    }
    @PutMapping("/{id}")
    public String modifierIntervention(@PathVariable Long id,@RequestBody Intervention intervention) {
    	return interventionRepository.findById(id).map(i->{
    		i.setMachine(intervention.getMachine());
    		i.setTechnicien(intervention.getTechnicien());
    		i.setValidationChefGarage(intervention.isValidationChefGarage());
    		i.setDescription(intervention.getDescription());
    		i.setKmOuHeureMoteur(intervention.getKmOuHeureMoteur());
    		i.setPhotoIntervention(intervention.getPhotoIntervention());
    		i.setSignatures(intervention.getSignatures());
    		i.setDateIntervention(intervention.getDateIntervention());
    		interventionRepository.save(i);
    		return "Intervention Modifier avec succès";
    	}).orElse("Intervention non Trouver");
    }
}
