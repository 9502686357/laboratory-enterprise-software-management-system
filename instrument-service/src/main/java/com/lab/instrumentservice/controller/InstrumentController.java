package com.lab.instrumentservice.controller;

import com.lab.instrumentservice.model.Instrument;
import com.lab.instrumentservice.service.InstrumentService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService service;

    public InstrumentController(
            InstrumentService service) {

        this.service = service;
    }

    @GetMapping
    public List<Instrument> getAllInstruments() {

        return service.getAllInstruments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrument(
            @PathVariable Long id) {

        return service.getInstrumentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instrument createInstrument(
            @RequestBody Instrument instrument) {

        return service.createInstrument(instrument);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrument(
            @PathVariable Long id) {

        service.deleteInstrument(id);

        return ResponseEntity.noContent().build();
    }
}
