package com.lab.experimentservice.controller;

import com.lab.experimentservice.model.Experiment;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/experiments")
public class ExperimentController {

    private final List<Experiment> experiments = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Experiment>> getAllExperiments() {
        return ResponseEntity.ok(experiments);
    }

    @PostMapping
    public ResponseEntity<Experiment> createExperiment(
            @RequestBody Experiment experiment) {

        experiment.setId(
                (long) (experiments.size() + 1)
        );

        experiments.add(experiment);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(experiment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experiment> getExperimentById(
            @PathVariable Long id) {

        return experiments.stream()
                .filter(experiment ->
                        experiment.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(
                        ResponseEntity.notFound().build()
                );
    }
}
