package com.garage.gestionGarage;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/travail")
public class TravailController {
    @Autowired
    TravailRepository travailRepository;
    @GetMapping
    public List<TravailDTO> afficherTravail(){
    	return travailRepository.findAll().stream().map(t ->convertToDTO(t)).collect(Collectors.toList());
    }
    @PostMapping
    public Travail ajouterTravail(@RequestBody Travail travail) {
    	if (travail.getHeureDebut() != null && travail.getHeureFin()!=null) {
    		long minutes=java.time.Duration.between(travail.getHeureDebut(), travail.getHeureFin()).toMinutes();
    		travail.setHeureTravailMachine(new java.math.BigDecimal(minutes).divide(new java.math.BigDecimal(60),2,java.math.RoundingMode.HALF_DOWN));
    	}
    	return travailRepository.save(travail);
    }
    @PutMapping("/{id}")
    public Travail modifierTravail(@PathVariable Long id,@RequestBody Travail travailModifier) {
    	return travailRepository.findById(id).map(t ->{
    		t.setMachine(travailModifier.getMachine());
    		t.setTechnicien(travailModifier.getTechnicien());
    		t.setHeureDebut(travailModifier.getHeureDebut());
    		t.setHeureFin(travailModifier.getHeureFin());
    		t.setPreuvePhoto(travailModifier.getPreuvePhoto());
    		if (t.getHeureDebut() != null && t.getHeureFin()!=null) {
        		long minutes=java.time.Duration.between(t.getHeureDebut(), t.getHeureFin()).toMinutes();
        		t.setHeureTravailMachine(new java.math.BigDecimal(minutes).divide(new java.math.BigDecimal(60),2,java.math.RoundingMode.HALF_DOWN));
        	}
    		return travailRepository.save(t);
    	}).orElseThrow(()-> new RuntimeException("Travail non Trouvée"));
    }
	private TravailDTO convertToDTO(Travail t) {
		TravailDTO dto=new TravailDTO();
		dto.setId(t.getId());
		dto.setTechnicienIdentite(t.getTechnicien().getNom()+" "+t.getTechnicien().getPrenom());
		dto.setMachineDesignation(t.getMachine().getType()+" - "+t.getMachine().getModele());
		dto.setHeureDebut(t.getHeureDebut());
		dto.setHeureFin(t.getHeureFin());
		dto.setHeureTravailMachine(t.getHeureTravailMachine());
		if(t.getPreuvePhoto()!=null) {
			String base64Image=Base64.getEncoder().encodeToString(t.getPreuvePhoto());
			dto.setPreuvePhotoBase64(base64Image);
		}
		
		return dto;
	}
}
