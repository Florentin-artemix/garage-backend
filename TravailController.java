package com.garage.gestionGarage;

import java.util.ArrayList;
import java.util.Base64;
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
		if(travail.getPreuvePhotoBase64()!=null) {
			String propre=travail.getPreuvePhotoBase64().replaceAll("\\s+", "");
			byte[] imagesBytes=Base64.getDecoder().decode(propre);
			travail.setPreuvePhoto(imagesBytes);
		}
		travailRepository.save(travail);
		return "Travail Enregistrer avec succès";
	}
	@GetMapping
	public List<TravailDTO>afficherTravail(){
		List<Travail> travaux=travailRepository.findAll();
		List<TravailDTO> dtoList=new ArrayList<>();
		for(Travail t : travaux) {
			String nomTech=t.getTechnicien().getNom();
			String prenomTech=t.getTechnicien().getPrenom();
			String typeMachine=t.getMachine().getType();
			String modeleMachine=t.getMachine().getModele();
			String heureDebut=t.getHeureDebut() !=null ?t.getHeureDebut().toString(): null;
			String heureFin=t.getHeureFin() !=null ?t.getHeureFin().toString(): null;
			String heureTravail=t.getHeureTravail() !=null ?t.getHeureTravail().toString(): null;
			String preuve64=t.getPreuvePhoto() !=null ? Base64.getEncoder().encodeToString(t.getPreuvePhoto()): null;
			dtoList.add(new TravailDTO(nomTech,prenomTech,typeMachine,modeleMachine,heureDebut,heureFin,heureTravail,preuve64));
		}
		return dtoList;
	}
	@PutMapping("/{id}")
	public String modifierTravail(@PathVariable Long id,@RequestBody Travail travailModifier) {
		return travailRepository.findById(id).map(t->{
			t.setMachine(travailModifier.getMachine());
			t.setTechnicien(travailModifier.getTechnicien());
			t.setHeureDebut(travailModifier.getHeureDebut());
			t.setHeureFin(travailModifier.getHeureFin());
			if(travailModifier.getPreuvePhotoBase64()!=null) {
				String propre=travailModifier.getPreuvePhotoBase64().replaceAll("\\s+", "");
				byte[] imagesBytes=Base64.getDecoder().decode(propre);
				t.setPreuvePhoto(imagesBytes);
			}
			travailRepository.save(t);
			return "Travail Modifier avec succes";
		}).orElse("Travail non Trouver");
	}
}