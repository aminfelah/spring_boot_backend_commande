
package com.example.payloads;




import java.time.LocalDate;

import javax.validation.constraints.*;
public class CommandeCreationRequest {
	
	 
	@NotBlank
	@Size(max = 20)
	private String titre;
	@Size(max = 20)
	private String id_du_devis;
	@Size(max = 20)
	private String nom_text_redige;
	private LocalDate date_creation;
	@Size(max = 15)
	private String langue;
	    
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

	
}