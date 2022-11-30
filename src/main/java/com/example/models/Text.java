package com.example.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
@Table(name = "texts")
public final class Text  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public long id;
	@NotBlank
	@Size(max = 20)
	@Size(min = 3)
	private String titre;

	private String contenu;
	private LocalDate date_creation;
	private LocalDate date_livraison;
	private LocalDate date_validation;
	private int  nombre_mot_redige;
	@Override
	public String toString() {
		return "Text [id=" + id + ", titre=" + titre + ", contenu=" + contenu + ", date_creation=" + date_creation
				+ ", date_livraison=" + date_livraison + ", date_validation=" + date_validation + ", nombre_mot_redige="
				+ nombre_mot_redige + "]";
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public LocalDate getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(LocalDate date_creation) {
		this.date_creation = date_creation;
	}
	public LocalDate getDate_livraison() {
		return date_livraison;
	}
	public void setDate_livraison(LocalDate date_livraison) {
		this.date_livraison = date_livraison;
	}
	public LocalDate getDate_validation() {
		return date_validation;
	}
	public void setDate_validation(LocalDate date_validation) {
		this.date_validation = date_validation;
	}
	public int getNombre_mot_redige() {
		return nombre_mot_redige;
	}
	public void setNombre_mot_redige(int nombre_mot_redige) {
		this.nombre_mot_redige = nombre_mot_redige;
	}
	public long getTextId() {
		return id;
	}
	public void setTextId(long textId) {
		this.id = textId;
	}
}