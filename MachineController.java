package com.garage.gestionGarage;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/machine")
@CrossOrigin(origins= "*")
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
}
