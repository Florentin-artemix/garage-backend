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
@RequestMapping("/api/travail")
public class TravailController{
	@Autowired
	TravailRepository travailRepository;
	@PostMapping
	public String ajouterTravail(@RequestBody Travail travail) {
		travailRepository.save(travail);
		return "Travail Enregistrer avec succès";
	}
	@GetMapping
	public List<Travail>afficherTravail(){
		return travailRepository.findAll();
	}
	@PutMapping("/{id}")
	public String modifierTravail(@PathVariable Long id,@RequestBody Travail travailModifier) {
		return travailRepository.findById(id).map(t->{
			t.setMachine(travailModifier.getMachine());
			t.setTechnicien(travailModifier.getTechnicien());
			t.setHeureDebut(travailModifier.getHeureDebut());
			t.setHeureFin(travailModifier.getHeureFin());
			travailRepository.save(t);
			return "Travail Modifier avec succes";
		}).orElse("Travail non Trouver");
	}
}