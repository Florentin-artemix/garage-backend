package com.garage.gestionGarage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TravailDTO {
    private Long id;
    private String technicienIdentite;
    private String MachineDesignation;
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    private BigDecimal heureTravailMachine;
    private String preuvePhotoBase64;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTechnicienIdentite() {
		return technicienIdentite;
	}
	public void setTechnicienIdentite(String technicienIdentite) {
		this.technicienIdentite = technicienIdentite;
	}
	public String getMachineDesignation() {
		return MachineDesignation;
	}
	public void setMachineDesignation(String machineDesignation) {
		MachineDesignation = machineDesignation;
	}
	public LocalDateTime getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(LocalDateTime heureDebut) {
		this.heureDebut = heureDebut;
	}
	public LocalDateTime getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(LocalDateTime heureFin) {
		this.heureFin = heureFin;
	}
	public BigDecimal getHeureTravailMachine() {
		return heureTravailMachine;
	}
	public void setHeureTravailMachine(BigDecimal heureTravailMachine) {
		this.heureTravailMachine = heureTravailMachine;
	}
	public String getPreuvePhotoBase64() {
		return preuvePhotoBase64;
	}
	public void setPreuvePhotoBase64(String preuvePhotoBase64) {
		this.preuvePhotoBase64 = preuvePhotoBase64;
	}
    
}
