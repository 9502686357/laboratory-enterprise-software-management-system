package com.lab.instrumentservice.service;

import com.lab.instrumentservice.model.Instrument;
import com.lab.instrumentservice.repository.InstrumentRepository;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class InstrumentServiceTest {

    private final InstrumentRepository repository =
            Mockito.mock(InstrumentRepository.class);

    private final InstrumentService service =
            new InstrumentService(repository);

    @Test
    void shouldReturnAllInstruments() {

        Instrument instrument = new Instrument(
                "Spectrometer",
                "Optical Analyzer",
                "LabTech",
                "ACTIVE"
        );

        when(repository.findAll())
                .thenReturn(Arrays.asList(instrument));

        List<Instrument> result =
                service.getAllInstruments();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(
                "Spectrometer",
                result.get(0).getName()
        );
    }

    @Test
    void shouldCreateInstrument() {

        Instrument instrument = new Instrument(
                "Microscope",
                "Digital Microscope",
                "LabTech",
                "ACTIVE"
        );

        when(repository.save(any(Instrument.class)))
                .thenReturn(instrument);

        Instrument result =
                service.createInstrument(instrument);

        assertNotNull(result);
        assertEquals(
                "Microscope",
                result.getName()
        );
        assertEquals(
                "ACTIVE",
                result.getStatus()
        );
    }
}
