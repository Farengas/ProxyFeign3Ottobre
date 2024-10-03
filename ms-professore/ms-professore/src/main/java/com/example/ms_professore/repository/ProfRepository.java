package com.example.ms_professore.repository;

import com.example.ms_professore.model.Professore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<Professore, Long> {
}
