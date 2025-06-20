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
@RequestMapping("/api/suivieVidange")
public class SuivieVidangeController {
    @Autowired
    SuivieVidangeRepository suivieRepository;
    @PostMapping
    public String ajouterSuivieVidange(@RequestBody SuivieVidange vidange) {
    	suivieRepository.save(vidange);
    	return "Suivie Vidange Ajouter avec succès";
    }
    @GetMapping
    public List<SuivieVidangeDTO>afficherDTO(){
    	return suivieRepository.findAll().stream().map(s->new SuivieVidangeDTO(
    		s.getId(),
    		s.getMachine().getType(),
    		s.getMachine().getModele(),
    		s.getDernierSceanceKm(),
    		s.getFrequence(),
    		s.getProchainSceanceKm(),
    		s.getProduitUtiliser(),
    		s.getQuantiteUtiliser(),
    		s.isAlerteVidange()
    	)).toList();
    }
    @PutMapping("/{id}")
    public String modifierSuivieVidange(@PathVariable Long id,@RequestBody SuivieVidange vidange) {
    	return suivieRepository.findById(id).map(s->{
    		s.setMachine(vidange.getMachine());
    		s.setDernierSceanceKm(vidange.getDernierSceanceKm());
    		s.setFrequence(vidange.getFrequence());
    		s.setProchainSceanceKm(vidange.getProchainSceanceKm());
    		s.setProduitUtiliser(vidange.getProduitUtiliser());
    		s.setQuantiteUtiliser(vidange.getQuantiteUtiliser());
    		s.setAlerteVidange(vidange.isAlerteVidange());
    		suivieRepository.save(s);
    		return "SuivieVidange Modifier avec succès";
    	}).orElse("Suivie Vidange non trouver");
    }
}
