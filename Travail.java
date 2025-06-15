package com.garage.gestionGarage;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 
@Entity
@Table(name="travail")
public class Travail{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name="machineId",nullable=false)
	private Machine machine;
	@ManyToOne
	@JoinColumn(name="technicienId",nullable=false)
	private Technicien technicien;
	private LocalDateTime heureDebut;
	private LocalDateTime heureFin;
	@Column(precision=5,scale=2)
	private BigDecimal heureTravail;
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
	public Technicien getTechnicien() {
		return technicien;
	}
	public void setTechnicien(Technicien technicien) {
		this.technicien = technicien;
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
	public BigDecimal getHeureTravail() {
		return heureTravail;
	}
	public void setHeureTravail(BigDecimal heureTravail) {
		this.heureTravail = heureTravail;
	}
	
}

