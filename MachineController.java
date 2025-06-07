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
@RequestMapping("/api/machine")
public class MachineController {
    @Autowired
    private MachineRepository machineRepository;
    @PostMapping
    public String ajouterMachine(@RequestBody Machine machine) {
    	machineRepository.save(machine);
    	return "Machine Enregistrer avec succes: "+machine.getModele();
    }
    @GetMapping
    public List<Machine> getMachine(){
    	return machineRepository.findAll();
    }
    @PutMapping("/{id}")
    public String modifierMachine(@PathVariable Long id,@RequestBody Machine machineModifier) {
    	return machineRepository.findById(id).map(machine -> {
    	    machine.setType(machineModifier.getType());
    	    machine.setModele(machineModifier.getModele());
    	    machine.setNumeroImmatriculation(machineModifier.getNumeroImmatriculation());
    	    machine.setDateMiseEnService(machineModifier.getDateMiseEnService());
    	    machine.setHeureServiceMoteur(machineModifier.getHeureServiceMoteur());
    	    machine.setdateProchainVidange(machineModifier.getDateProchainVidange());
    	    machine.setStatutActuel(machineModifier.getStatutActuel());
    	    machineRepository.save(machine);
    	    return "Machine Modifier avec succès.";
    	}).orElse("Machine non Trouvée");
    }
}
