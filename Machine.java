package com.garage.gestionGarage;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class Machine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String type;
	private String modele;
    private String numeroImmatriculation;
    private LocalDate dateMiseEnService;
    private LocalTime heureServiceMoteur;
    private LocalDate dateProchainVidange;
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Statut statutActuel;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getNumeroImmatriculation() {
		return numeroImmatriculation;
	}
	public void setNumeroImmatriculation(String numeroImmatriculation) {
		this.numeroImmatriculation = numeroImmatriculation;
	}
	public LocalDate getDateMiseEnService() {
		return dateMiseEnService;
	}
	public void setDateMiseEnService(LocalDate dateMiseEnService) {
		this.dateMiseEnService = dateMiseEnService;
	}
	public LocalTime getHeureServiceMoteur() {
		return heureServiceMoteur;
	}
	public void setHeureServiceMoteur(LocalTime heureServiceMoteur) {
		this.heureServiceMoteur = heureServiceMoteur;
	}
	public LocalDate getDateProchainVidange() {
		return dateProchainVidange;
	}
	public void setdateProchainVidange(LocalDate prochainVidange) {
		this.dateProchainVidange = prochainVidange;
	}
	public Statut getStatutActuel() {
		return statutActuel;
	}
	public void setStatutActuel(Statut statutActuel) {
		this.statutActuel = statutActuel;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
   
}
