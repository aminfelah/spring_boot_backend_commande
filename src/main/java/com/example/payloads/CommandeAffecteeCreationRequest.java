package com.example.payloads;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.example.models.Redacteur;
import com.example.models.Text;



public class CommandeAffecteeCreationRequest {
	private int nombre_text_affecte;
    private int tarif;
    private int nombre_mot_min;
    private int nombre_mot_max;
    private LocalDate deadline;
    private String titre;
	private String id_du_devis;
	private String nom_text_redige;
	private LocalDate date_creation;
	private String langue;
	private TypeCommande type;
    public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getId_du_devis() {
		return id_du_devis;
	}
	public void setId_du_devis(String id_du_devis) {
		this.id_du_devis = id_du_devis;
	}
	public String getNom_text_redige() {
		return nom_text_redige;
	}
	public void setNom_text_redige(String nom_text_redige) {
		this.nom_text_redige = nom_text_redige;
	}
	public LocalDate getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}
	public String getLangue() {
		return langue;
	}
	public void setLangue(String langue) {
		this.langue = langue;
	}

	public int getNombre_text_affecte() {
		return nombre_text_affecte;
	}
	public TypeCommande getType() {
		return type;
	}
	public void setType(TypeCommande type) {
		this.type = type;
	}
	public void setNombre_text_affecte(int nombre_text_affecte) {
		this.nombre_text_affecte = nombre_text_affecte;
	}
	public int getTarif() {
		return tarif;
	}
	public void setTarif(int tarif) {
		this.tarif = tarif;
	}
	public int getNombre_mot_min() {
		return nombre_mot_min;
	}
	public void setNombre_mot_min(int nombre_mot_min) {
		this.nombre_mot_min = nombre_mot_min;
	}
	public int getNombre_mot_max() {
		return nombre_mot_max;
	}
	public void setNombre_mot_max(int nombre_mot_max) {
		this.nombre_mot_max = nombre_mot_max;
	}
	public LocalDate getDeadline() {
		return deadline;
	}
	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}
}

