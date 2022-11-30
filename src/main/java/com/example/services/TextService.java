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
import com.example.payloads.TextCreationRequest;
import com.example.payloads.TypeCommande;
import com.example.repositories.CommandeAffecteRepository;
import com.example.repositories.CommandeRepository;
import com.example.repositories.RedacteurRepository;
import com.example.repositories.TextRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TextService {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	CommandeAffecteRepository commandeAffecteRepository;
	@Autowired
	TextRepository textRepository;
	@Autowired
	RedacteurRepository redacteurRepository;



	public List<Text> findAll() {
		return this.textRepository.findAll();
	}
	

	public Text findById(@PathVariable("textId") final Long textId) {
		return this.textRepository.findById(textId).get();
	}

	public Text save(@RequestBody final TextCreationRequest textPayload) {
		Text newText = new Text();
		newText.setTitre(textPayload.getTitre());
		newText.setContenu(textPayload.getContenu());
		newText.setDate_creation(textPayload.getDate_creation());
		newText.setDate_livraison(textPayload.getDate_livraison());
		newText.setDate_validation(textPayload.getDate_validation());
		newText.setDate_validation(textPayload.getDate_validation());
		newText.setNombre_mot_redige(textPayload.getNombre_mot_redige());
		textRepository.save(newText);
		
		return newText;
	}
	

}
