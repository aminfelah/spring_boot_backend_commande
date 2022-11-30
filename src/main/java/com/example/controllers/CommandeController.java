package com.example.controllers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.models.Commande;
import com.example.models.CommandeAffecte;
import com.example.payloads.CommandeAffecteeCreationRequest;
import com.example.payloads.CommandeCreationRequest;

import com.example.services.CommandeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/commande")
public class CommandeController {

	@Autowired
	CommandeService commandeService;

	@GetMapping("/")
	public String welcome() {
		return "This is the commande controller";
	}

	@GetMapping("/all")
	public ResponseEntity<List<Commande>> findAll() {
		return new ResponseEntity<>(commandeService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{redacteurId}")
	public ResponseEntity<Object> findById(@PathVariable("commandeId") final Long commandeId) {
		return new ResponseEntity<>(commandeService.findById(commandeId), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Commande> save(@RequestBody final CommandeCreationRequest commandePayload) {

		return new ResponseEntity<>(commandeService.save(commandePayload), HttpStatus.CREATED);
	}

	@PostMapping("/create/affecte")
	public ResponseEntity<CommandeAffecte> saveAffecte(
			@RequestBody final CommandeAffecteeCreationRequest commandeAffectePayload) {

		return new ResponseEntity<>(commandeService.saveAffecte(commandeAffectePayload), HttpStatus.CREATED);
	}

	@PatchMapping("/update/{commandeId}/affecte")
	public ResponseEntity<CommandeAffecte> transformIntoAffecte(
			@RequestBody final CommandeAffecteeCreationRequest commandeAffectePayload,
			@PathVariable("commandeId") final Long commandeId) {

		return new ResponseEntity<>(commandeService.transformIntoAffecte(commandeAffectePayload, commandeId),
				HttpStatus.OK);
	}

	@PatchMapping("/update/{textId}/{commandeId}/affecte")
	public ResponseEntity<Object> attachTextToCommande(@PathVariable("textId") final Long textId,
			@PathVariable("commandeId") final Long commandeId) {

		return new ResponseEntity<>(commandeService.attachRedacteurToCommande(textId, commandeId), HttpStatus.OK);
	}

	@PatchMapping("/update/{redacteurId}/{commandeId}/affecte")
	public ResponseEntity<Object> attachRedacteurToCommande(@PathVariable("redacteurId") final Long redacteurId,
			@PathVariable("commandeId") final Long commandeId) {

		return new ResponseEntity<>(commandeService.attachRedacteurToCommande(redacteurId, commandeId), HttpStatus.OK);
	}

	@GetMapping("/commande/text-livree/{date_locale}")
	public ResponseEntity<List<Commande>> commandeTextLivre(@PathVariable("date_locale") final LocalDate date_locale) {

		return new ResponseEntity<>(commandeService.commandeTextLivre(date_locale), HttpStatus.OK);
	}

	@GetMapping("/commande/text-validee/{date_locale}")
	public ResponseEntity<List<Commande>> commandeTextValide(@PathVariable("date_locale") final LocalDate date_locale) {

		return new ResponseEntity<>(commandeService.commandeTextValide(date_locale), HttpStatus.OK);
	}

	@GetMapping("/commande/redacteur/{date_locale}")
	public ResponseEntity<List<CommandeAffecte>> commandeRetard(
			@PathVariable("date_locale") final LocalDate date_locale) {

		return new ResponseEntity<>(commandeService.commandeRetard(date_locale), HttpStatus.OK);
	}

	@GetMapping("/commande/cout-estime/{commande_Id}/{date_locale}")
	public int coutTotalEstime(@PathVariable("commande_Id") final long commandeId,
			@PathVariable("date_locale") final LocalDate date_locale) {

		return commandeService.coutTotalEstime(commandeId, date_locale);
	}

	@GetMapping("/commande/cout-achat/{commande_Id}/{date_locale}")
	public int coutAchat(@PathVariable("commande_Id") final long commandeId,
			@PathVariable("date_locale") final LocalDate date_locale) {

		return commandeService.coutAchat(commandeId, date_locale);
	}

	@GetMapping("/commande/cout-facture/{commande_Id}/{date_locale}")
	public int coutFacture(@PathVariable("commande_Id") final long commandeId,
			@PathVariable("date_locale") final LocalDate date_locale) {

		return commandeService.coutFacture(commandeId, date_locale);
	}

}