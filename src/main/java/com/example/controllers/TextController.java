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

import com.example.models.Text;
import com.example.payloads.TextCreationRequest;
import com.example.repositories.TextRepository;
import com.example.services.TextService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/text")
public class TextController {
	@Autowired
	TextService textService;

	@GetMapping("/")
	public String welcome() {
		return "This is the text controller";
	}

	@GetMapping("/all")
	public ResponseEntity<List<Text>> findAll() {
		return new ResponseEntity<>(textService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{textId}")
	public ResponseEntity<Object> findById(@PathVariable("textId") final Long textId) {
		return new ResponseEntity<>(textService.findById(textId), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Text> save(@RequestBody final TextCreationRequest textPayload) {

		return new ResponseEntity<>(textService.save(textPayload), HttpStatus.CREATED);
	}

}