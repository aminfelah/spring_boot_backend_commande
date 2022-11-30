package com.example.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "commandes")
public class Commande  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	public Long id;
	@NotBlank
	@Size(max = 20)
	private String titre;
	@Size(max = 20)
	@Column(unique=true)
	private String id_du_devis;
	@Size(max = 20)
	private String nom_text_redige;
	@Size(max = 20)
	private LocalDate date_creation;
	@Size(max = 20)
	private String langue;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "redacteurs_commandes")
	private Set<Redacteur> redacteurs = new HashSet<>();
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name = "commande_id", referencedColumnName = "id")
	 private Set<Text> texts = new HashSet<>(); 
	public Long getCommandeId() {
		return id;
	}
	public void setCommandeId(Long commandeId) {
		this.id = commandeId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public Set<Redacteur> getRedacteurs() {
		return redacteurs;
	}
	public void setRedacteurs(Set<Redacteur> redacteurs) {
		this.redacteurs = redacteurs;
	}
	public Set<Text> getTexts() {
		return texts;
	}
	public void setTexts(Set<Text> texts) {
		this.texts = texts;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

