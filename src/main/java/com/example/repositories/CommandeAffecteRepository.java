package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.CommandeAffecte;

public interface CommandeAffecteRepository  extends JpaRepository<CommandeAffecte, Long> {

}
