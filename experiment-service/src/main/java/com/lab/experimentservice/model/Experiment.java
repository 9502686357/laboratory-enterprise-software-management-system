package com.lab.experimentservice.model;

public class Experiment {

    private Long id;

    private String name;

    private String description;

    private String instrumentName;

    private String status;

    public Experiment() {
    }

    public Experiment(
            String name,
            String description,
            String instrumentName,
            String status
    ) {
        this.name = name;
        this.description = description;
        this.instrumentName = instrumentName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
