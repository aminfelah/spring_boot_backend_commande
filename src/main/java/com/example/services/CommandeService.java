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
import com.example.payloads.TypeCommande;
import com.example.repositories.CommandeAffecteRepository;
import com.example.repositories.CommandeRepository;
import com.example.repositories.RedacteurRepository;
import com.example.repositories.TextRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandeService {

	@Autowired
	CommandeRepository commandeRepository;
	@Autowired
	CommandeAffecteRepository commandeAffecteRepository;
	@Autowired
	TextRepository textRepository;
	@Autowired
	RedacteurRepository redacteurRepository;

	public List<Commande> findAll() {
		return commandeRepository.findAll();
	}

	public Commande findById(Long commandeId) {
		return commandeRepository.findById(commandeId).get();
	}

	public Commande save(CommandeCreationRequest commandePayload) {
		Commande newCommande = new Commande();
		newCommande.setTitre(commandePayload.getTitre());
		newCommande.setId_du_devis(commandePayload.getId_du_devis());
		newCommande.setNom_text_redige(commandePayload.getNom_text_redige());
		newCommande.setDate_creation(commandePayload.getDate_creation());
		newCommande.setLangue(commandePayload.getLangue());
		newCommande.setDate_creation(commandePayload.getDate_creation());

		commandeRepository.save(newCommande);

		return newCommande;
	}

	public CommandeAffecte saveAffecte(CommandeAffecteeCreationRequest commandeAffectePayload) {
		CommandeAffecte newCommande = new CommandeAffecte();
		newCommande.setTitre(commandeAffectePayload.getTitre());
		newCommande.setId_du_devis(commandeAffectePayload.getId_du_devis());
		newCommande.setNom_text_redige(commandeAffectePayload.getNom_text_redige());
		newCommande.setDate_creation(commandeAffectePayload.getDate_creation());
		newCommande.setLangue(commandeAffectePayload.getLangue());
		newCommande.setDate_creation(commandeAffectePayload.getDate_creation());
		newCommande.setNombre_text_affecte(commandeAffectePayload.getNombre_text_affecte());
		newCommande.setNombre_mot_min(commandeAffectePayload.getNombre_mot_min());
		newCommande.setNombre_mot_max(commandeAffectePayload.getNombre_mot_max());
		newCommande.setTarif(commandeAffectePayload.getTarif());
		newCommande.setType(commandeAffectePayload.getType());

		commandeAffecteRepository.save(newCommande);

		return newCommande;
	}

	public CommandeAffecte transformIntoAffecte(CommandeAffecteeCreationRequest commandeAffectePayload,
			Long commandeId) {
		CommandeAffecte updateCommande = new CommandeAffecte();
		Optional<Commande> oldCommande = commandeRepository.findById(commandeId);
		updateCommande.setTitre(oldCommande.get().getTitre());
		updateCommande.setId_du_devis(oldCommande.get().getId_du_devis());
		updateCommande.setNom_text_redige(oldCommande.get().getNom_text_redige());
		updateCommande.setDate_creation(oldCommande.get().getDate_creation());
		updateCommande.setLangue(oldCommande.get().getLangue());
		updateCommande.setDate_creation(oldCommande.get().getDate_creation());
		updateCommande.setNombre_text_affecte(commandeAffectePayload.getNombre_text_affecte());
		updateCommande.setNombre_mot_min(commandeAffectePayload.getNombre_mot_min());
		updateCommande.setNombre_mot_max(commandeAffectePayload.getNombre_mot_max());
		updateCommande.setTarif(commandeAffectePayload.getTarif());
		updateCommande.setType(commandeAffectePayload.getType());

		commandeRepository.delete(oldCommande.get());
		commandeAffecteRepository.save(updateCommande);

		return updateCommande;
	}

	public Commande attachTextToCommande( final Long textId,
			@PathVariable("commandeId") final Long commandeId) {
		Optional<Commande> commande = commandeRepository.findById(commandeId);
		Optional<Text> text = textRepository.findById(commandeId);
		Set<Text> texts = commande.get().getTexts();
		texts.add(text.get());
		commande.get().setTexts(texts);
		commandeRepository.save(commande.get());

		return commande.get();
	}

	public ResponseEntity<Commande> attachRedacteurToCommande(@PathVariable("redacteurId") final Long redacteurId,
			@PathVariable("commandeId") final Long commandeId) {
		Optional<Commande> commande = commandeRepository.findById(commandeId);
		Optional<Redacteur> redacteur = redacteurRepository.findById(commandeId);
		Set<Redacteur> redacteurs = commande.get().getRedacteurs();
		redacteurs.add(redacteur.get());
		commande.get().setRedacteurs(redacteurs);
		commandeRepository.save(commande.get());
		return new ResponseEntity<>(commande.get(), HttpStatus.OK);
	}

	public List<Commande> commandeTextLivre(LocalDate date_locale) {
		List<Commande> commandes = commandeRepository.findAll();
		List<Commande> commandeTextLivree = new ArrayList<Commande>();
		for (Commande commande : commandes) {
			boolean estTotallementLivree = true;
			for (Text text : commande.getTexts()) {
				if (!(text.getDate_livraison().isBefore(date_locale)
						&& text.getDate_validation().isAfter(date_locale))) {
					estTotallementLivree = false;
				}
			}
			if (estTotallementLivree) {
				commandeTextLivree.add(commande);
			}
		}
		return commandeTextLivree;
	}

	public List<Commande> commandeTextValide(LocalDate date_locale) {
		List<Commande> commandes = commandeRepository.findAll();
		List<Commande> commandeTextValide = new ArrayList<Commande>();
		for (Commande commande : commandes) {
			boolean estTotallementValide = true;
			for (Text text : commande.getTexts()) {
				if (!text.getDate_validation().isBefore(date_locale)) {
					estTotallementValide = false;
				}
			}
			if (estTotallementValide) {
				commandeTextValide.add(commande);
			}
		}
		return commandeTextValide;
	}

	public List<CommandeAffecte> commandeRetard(LocalDate date_locale) {
		List<CommandeAffecte> commandes = commandeAffecteRepository.findAll();
		List<CommandeAffecte> commandesRetard = new ArrayList<CommandeAffecte>();
		for (CommandeAffecte commande : commandes) {
			boolean toutEstEnAvance = true;
			int compteurText = 0;
			for (Text text : commande.getTexts()) {
				if (!(text.getDate_livraison().isAfter(commande.getDeadline())
						&& date_locale.isAfter(commande.getDeadline()))) {
					compteurText += 1;
					if (compteurText > commande.getNombre_text_affecte()) {
						toutEstEnAvance = false;
					}

				}
			}
			if (!toutEstEnAvance) {
				commandesRetard.add(commande);
			}
		}
		return commandesRetard;
	}

	public int coutAchat(long commandeId, LocalDate date_locale) {
		CommandeAffecte commande = commandeAffecteRepository.findById(commandeId).get();
		if (commande.getType().equals(TypeCommande.FERME)) {
			int nombre_text_livree = 0;
			for (Text text : commande.getTexts()) {
				if ((text.getDate_livraison().isBefore(date_locale)
						&& text.getDate_validation().isAfter(date_locale))) {
					nombre_text_livree += 1;
				}
			}
			return commande.getNombre_mot_max() * commande.getTarif() * (nombre_text_livree);
		} else {
			int sumAchat = 0;
			for (Text text : commande.getTexts()) {
				if (text.getNombre_mot_redige() > commande.getNombre_mot_max()) {
					sumAchat += text.getNombre_mot_redige() * 1.1 * commande.getTarif();
				} else {
					sumAchat += text.getNombre_mot_redige() * commande.getTarif();

				}

			}
			return sumAchat;
		}
	}

	public int coutFacture(long commandeId, LocalDate date_locale) {
		CommandeAffecte commande = commandeAffecteRepository.findById(commandeId).get();
		if (commande.getType().equals(TypeCommande.FERME)) {
			int nombre_text_validee = 0;
			for (Text text : commande.getTexts()) {
				if (text.getDate_validation().isBefore(date_locale)) {
					nombre_text_validee += 1;
				}
			}
			return commande.getNombre_mot_min() * commande.getTarif() * (nombre_text_validee);
		} else {
			int sumFacture = 0;
			for (Text text : commande.getTexts()) {
				if (text.getNombre_mot_redige() > commande.getNombre_mot_max()) {
					sumFacture += text.getNombre_mot_redige() * 1.1 * commande.getTarif();
				} else if (text.getNombre_mot_redige() > commande.getNombre_mot_min()) {
					sumFacture += text.getNombre_mot_redige() * commande.getTarif();

				}

			}
			return sumFacture;
		}

	}

	public int coutTotalEstime(long commandeId, LocalDate date_locale) {
		CommandeAffecte commande = commandeAffecteRepository.findById(commandeId).get();
		return commande.getTexts().size() * commande.getTarif() * commande.getNombre_mot_min();
	}
}
