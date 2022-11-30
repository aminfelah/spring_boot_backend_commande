package com.example.payloads;


import java.time.LocalDate;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RedacteurCreationRequest {
	@NotBlank
	@Size(min = 3, max = 20)
	private String nom;

	@NotBlank
	private String prenom;

	@Email
	private String email;

	private String entreprise;

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getEmail() {
		return email;
	}

	public String getEntreprise() {
		return entreprise;
	}



}
