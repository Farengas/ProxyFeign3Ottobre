package com.example.ms_genitori.service.impl;

import com.example.ms_genitori.model.Genitore;
import com.example.ms_genitori.repository.GenitoreRepository;
import com.example.ms_genitori.service.IGenitoreService;
import com.example.ms_proxyfeign.model.GenericFeignClient;
import com.example.ms_proxyfeign.proxy.StudenteProxy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class IGenitoreServiceImpl implements IGenitoreService {

    @Autowired
    @Lazy
    private  StudenteProxy studenteProxy;

    @Autowired
    private GenitoreRepository genitoreRepository;



    public IGenitoreServiceImpl() {
    }

    @Override
    public Genitore createGenitore(Genitore genitore) {
        // Save the genitore using the repository
        return genitoreRepository.save(genitore);
    }

    @Override
    public Genitore getGenitoreById(Long id) {
        // Retrieve the genitore from the repository
        Optional<Genitore> optionalGenitore = genitoreRepository.findById(id);
        return optionalGenitore.orElse(null); // Return null if not found
    }

    @Override
    public List<Genitore> getAllGenitori() {
        // Get all genitori from the repository
        return genitoreRepository.findAll();
    }

    @Override
    public Genitore updateGenitore(Long id, Genitore genitore) {
        // Check if the genitore exists
        if (genitoreRepository.existsById(id)) {
            genitore.setIdGenitore(id); // Ensure the ID is set for the update
            return genitoreRepository.save(genitore); // Update the genitore
        }
        return null; // Return null if not found
    }

    @Override
    public void deleteGenitore(Long id) {
        // Delete the genitore if it exists
        genitoreRepository.deleteById(id);
    }

    @Override
    public List<?> provaStudenti() {
        return studenteProxy.getAllStudenti();
    }



    @Override
    public List<?> getStudentiForGenitore(Long genitoreId) {
        // Retrieve students associated with this genitore
        // Assuming you have a method in the repository or service to get students by genitore ID
        return studenteProxy.getAllStudenti(); // Adjust based on your actual requirement
    }

    @Override
    public Optional<?> getStudenteForGenitore(Long genitoreId, Long studenteId) {
        // Retrieve a specific student associated with this genitore
        return studenteProxy.getStudenteById(studenteId); // Adjust based on your actual requirement
    }



    @Override
    public void deleteStudenteForGenitore(Long genitoreId, Long studenteId) {
        // Delete a specific student associated with this genitore
        studenteProxy.deleteStudente(studenteId);
    }

    @Override
    public Optional<?> getStudenteById(Long idStudente) {
        return studenteProxy.getStudenteById(idStudente);
    }
}
