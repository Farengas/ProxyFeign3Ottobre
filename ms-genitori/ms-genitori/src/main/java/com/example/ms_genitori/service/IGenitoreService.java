package com.example.ms_genitori.service;

import com.example.ms_genitori.model.Genitore;
import com.example.ms_proxyfeign.model.GenericFeignClient;
import com.example.ms_studente.model.Studente;

import java.util.List;
import java.util.Optional;

public interface IGenitoreService {
    Genitore createGenitore(Genitore genitore);

    // Ottiene un genitore per ID
    Genitore getGenitoreById(Long id);

    // Ottiene tutti i genitori
    List<Genitore> getAllGenitori();

    // Aggiorna i dettagli di un genitore
    Genitore updateGenitore(Long id, Genitore genitore);

    // Elimina un genitore per ID
    void deleteGenitore(Long id);

    List<Studente> provaStudenti();

    List<?> getStudentiForGenitore(Long genitoreId);
    Optional<?> getStudenteForGenitore(Long genitoreId, Long studenteId);
   void deleteStudenteForGenitore(Long genitoreId, Long studenteId);
    Optional<?> getStudenteById(Long idStudente);
}
