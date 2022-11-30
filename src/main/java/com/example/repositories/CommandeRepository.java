package com.example.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Commande;




@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	Commande findById(long id) ; 
	
}