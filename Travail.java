package com.garage.gestionGarage;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Travail {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="machine_id")
    private Machine machine;
    @ManyToOne
    @JoinColumn(name="technicien_id")
    private Technicien technicien;
    private LocalDateTime heureDebut;
    private LocalDateTime heureFin;
    @Column(precision=4,scale=2)
    private BigDecimal heureTravailMachine;
    @Lob
    private byte[] preuvePhoto;
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
	public BigDecimal getHeureTravailMachine() {
		return heureTravailMachine;
	}
	public void setHeureTravailMachine(BigDecimal heureTravailMachine) {
		this.heureTravailMachine = heureTravailMachine;
	}
	public byte[] getPreuvePhoto() {
		return preuvePhoto;
	}
	public void setPreuvePhoto(byte[] preuvePhoto) {
		this.preuvePhoto = preuvePhoto;
	}
    	
}
