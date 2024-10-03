package com.example.ms_studente.service.impl;

import com.example.ms_studente.model.Studente;
import com.example.ms_studente.repository.StudenteRepository;
import com.example.ms_studente.service.IStudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IStudenteServiceImpl implements IStudenteService {

    @Autowired
    private StudenteRepository studenteRepository;
    @Override
    public Studente createStudente(Studente studente) {
        return studenteRepository.save(studente);
    }

    @Override
    public List<Studente> getAllStudenti() {
        return studenteRepository.findAll();
    }

    @Override
    public Optional<Studente> getStudenteById(Long idStudente) {
        return studenteRepository.findById(idStudente);
    }

    @Override
    public Studente updateStudente(Long idStudente, Studente studenteDetails) {
        Optional<Studente> optionalStudente = studenteRepository.findById(idStudente);
        if (optionalStudente.isPresent()) {
            Studente existingStudente = optionalStudente.get();
            existingStudente.setNomeStudente(studenteDetails.getNomeStudente());
            existingStudente.setCognomeStudente(studenteDetails.getCognomeStudente());
            return studenteRepository.save(existingStudente);
        } else {
            return null; // O gestisci l'assenza con un'eccezione personalizzata
        }
    }

    @Override
    public void deleteStudente(Long idStudente) {
        Optional<Studente> optionalStudente = studenteRepository.findById(idStudente);
        optionalStudente.ifPresent(studente -> studenteRepository.delete(studente));
    }
}
