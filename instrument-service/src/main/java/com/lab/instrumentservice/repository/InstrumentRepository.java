package com.lab.instrumentservice.repository;

import com.lab.instrumentservice.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository
        extends JpaRepository<Instrument, Long> {
}
