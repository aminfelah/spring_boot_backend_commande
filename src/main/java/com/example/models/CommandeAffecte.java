package com.example.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.example.payloads.TypeCommande;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class CommandeAffecte extends Commande {

	private static final long serialVersionUID = 1L;
	private int nombre_text_affecte;
	private int tarif;
	private int nombre_mot_min;
	private int nombre_mot_max;
	private LocalDate deadline;
	@Enumerated(EnumType.ORDINAL)
	private TypeCommande type;

	public int getNombre_text_affecte() {
		return nombre_text_affecte;
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

	public TypeCommande getType() {
		return type;
	}

	public void setType(TypeCommande type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

