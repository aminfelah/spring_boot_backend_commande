package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Text;

@Repository
public interface TextRepository extends JpaRepository<Text, Long> {
	
}