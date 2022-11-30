package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.models.Redacteur;
import com.example.models.Text;
import com.example.payloads.RedacteurCreationRequest;
import com.example.repositories.RedacteurRepository;
import com.example.services.RedacteurService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/redacteur")
public class RedacteurController {
	@Autowired
	RedacteurService redacteurService;

	@GetMapping("/")
	public String welcome() {
		return "This is the redacteur controller";
	}

	@GetMapping("/all")
	public ResponseEntity<List<Redacteur>> findAll() {
		return new ResponseEntity<>(redacteurService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{redacteurId}")
	public ResponseEntity<Object> findById(@PathVariable("redacteurId") final Long redacteurId) {
		return new ResponseEntity<>(redacteurService.findById(redacteurId), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Redacteur> save(@RequestBody final RedacteurCreationRequest redacteurPayload) {
		return new ResponseEntity<>(redacteurService.save(redacteurPayload), HttpStatus.CREATED);
	}

}