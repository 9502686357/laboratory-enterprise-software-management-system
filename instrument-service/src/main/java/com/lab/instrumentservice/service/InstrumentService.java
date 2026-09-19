package com.lab.instrumentservice.service;

import com.lab.instrumentservice.model.Instrument;
import com.lab.instrumentservice.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {

    private final InstrumentRepository repository;

    public InstrumentService(
            InstrumentRepository repository) {

        this.repository = repository;
    }

    public List<Instrument> getAllInstruments() {
        return repository.findAll();
    }

    public Optional<Instrument> getInstrumentById(Long id) {
        return repository.findById(id);
    }

    public Instrument createInstrument(
            Instrument instrument) {

        return repository.save(instrument);
    }

    public void deleteInstrument(Long id) {
        repository.deleteById(id);
    }
}
