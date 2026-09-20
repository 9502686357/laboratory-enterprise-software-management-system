package com.lab.experimentservice.controller;

import com.lab.experimentservice.model.Experiment;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExperimentController.class)
public class ExperimentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateExperiment() throws Exception {

        String experimentJson = """
                {
                    "name": "Spectroscopy Analysis",
                    "description": "Laboratory sample analysis",
                    "instrumentName": "Laboratory Spectrometer",
                    "status": "RUNNING"
                }
                """;

        mockMvc.perform(
                post("/api/experiments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(experimentJson)
        )
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.name")
                .value("Spectroscopy Analysis"))
        .andExpect(jsonPath("$.status")
                .value("RUNNING"));
    }

    @Test
    void shouldGetAllExperiments() throws Exception {

        mockMvc.perform(
                get("/api/experiments")
        )
        .andExpect(status().isOk());
    }
}
