package com.garage.gestionGarage;

import jakarta.persistence.*;

@Entity
public class SuivieVidange {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="machineId")
	private Machine machine;
	private int dernierSceanceKm;
	private int frequence=2500;
	private int prochainSceanceKm;
	private String produitUtiliser;
	private double quantiteUtiliser;
	private boolean alerteVidange=false;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Machine getMachine() {
		return machine;
	}
	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	public int getDernierSceanceKm() {
		return dernierSceanceKm;
	}
	public void setDernierSceanceKm(int dernierSceanceKm) {
		this.dernierSceanceKm = dernierSceanceKm;
	}
	public int getFrequence() {
		return frequence;
	}
	public void setFrequence(int frequence) {
		this.frequence = frequence;
	}
	public int getProchainSceanceKm() {
		return prochainSceanceKm;
	}
	public void setProchainSceanceKm(int prochainSceanceKm) {
		this.prochainSceanceKm = prochainSceanceKm;
	}
	public String getProduitUtiliser() {
		return produitUtiliser;
	}
	public void setProduitUtiliser(String produitUtiliser) {
		this.produitUtiliser = produitUtiliser;
	}
	public double getQuantiteUtiliser() {
		return quantiteUtiliser;
	}
	public void setQuantiteUtiliser(double quantiteUtiliser) {
		this.quantiteUtiliser = quantiteUtiliser;
	}
	public boolean isAlerteVidange() {
		return alerteVidange;
	}
	public void setAlerteVidange(boolean alerteVidange) {
		this.alerteVidange = alerteVidange;
	}
	
}
