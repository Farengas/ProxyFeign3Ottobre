package com.example.ms_studente.service;

import com.example.ms_studente.model.Studente;

import java.util.List;
import java.util.Optional;

public interface IStudenteService {

    Studente createStudente(Studente studente);

    // Ottieni tutti gli studenti
    List<Studente> getAllStudenti();

    // Ottieni uno studente per ID
    Optional<Studente> getStudenteById(Long idStudente);

    // Aggiorna uno studente esistente
    Studente updateStudente(Long idStudente, Studente studenteDetails);

    // Elimina uno studente per ID
    void deleteStudente(Long idStudente);

}
