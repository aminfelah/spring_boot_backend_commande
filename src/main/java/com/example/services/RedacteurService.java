package com.example.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.models.Commande;
import com.example.models.CommandeAffecte;
import com.example.models.Redacteur;
import com.example.models.Text;
import com.example.payloads.CommandeAffecteeCreationRequest;
import com.example.payloads.CommandeCreationRequest;
import com.example.payloads.RedacteurCreationRequest;
import com.example.payloads.TypeCommande;
import com.example.repositories.CommandeAffecteRepository;
import com.example.repositories.CommandeRepository;
import com.example.repositories.RedacteurRepository;
import com.example.repositories.TextRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RedacteurService {


	@Autowired
	RedacteurRepository redacteurRepository;
	@GetMapping("/all")
	public List<Redacteur> findAll() {
		return this.redacteurRepository.findAll();
	}
	

	public Redacteur findById(Long redacteurId) {
		return this.redacteurRepository.findById(redacteurId).get();
	}

	public Redacteur save( RedacteurCreationRequest redacteurPayload) {
		Redacteur newRedacteur = new Redacteur();
		newRedacteur.setNom(redacteurPayload.getNom());
		newRedacteur.setPrenom(redacteurPayload.getPrenom());
		newRedacteur.setEmail(redacteurPayload.getEmail());
		newRedacteur.setEntreprise(redacteurPayload.getEntreprise());
		
		redacteurRepository.save(newRedacteur);
		
		return newRedacteur;
	}

}
