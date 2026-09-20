package com.lab.instrumentservice;

import com.lab.instrumentservice.model.Instrument;
import com.lab.instrumentservice.repository.InstrumentRepository;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class InstrumentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InstrumentRepository repository;

    @Test
    void shouldCreateAndRetrieveInstrument()
            throws Exception {

        String instrumentJson = """
                {
                    "name": "Laboratory Spectrometer",
                    "type": "Optical Analyzer",
                    "manufacturer": "LabTech",
                    "status": "ACTIVE"
                }
                """;

        mockMvc.perform(
                post("/api/instruments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(instrumentJson)
        )
        .andExpect(status().isOk());

        mockMvc.perform(
                get("/api/instruments")
        )
        .andExpect(status().isOk())
        .andExpect(
                jsonPath("$[0].name")
                        .value("Laboratory Spectrometer")
        );
    }
}
