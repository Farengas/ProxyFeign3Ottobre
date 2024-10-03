package com.example.ms_scuola.repository;

import com.example.ms_scuola.model.Scuola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScuolaRepository extends JpaRepository<Scuola, Long> {
}
