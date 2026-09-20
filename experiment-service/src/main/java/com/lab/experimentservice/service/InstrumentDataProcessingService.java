package com.lab.experimentservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class InstrumentDataProcessingService {

    public List<Double> parseData(String rawData) {

        List<Double> values = new ArrayList<>();

        if (rawData == null || rawData.isBlank()) {
            return values;
        }

        String[] dataPoints = rawData.split(",");

        for (String dataPoint : dataPoints) {
            try {
                values.add(Double.parseDouble(dataPoint.trim()));
            } catch (NumberFormatException exception) {
                // Ignore invalid data points
            }
        }

        return values;
    }

    public double calculateAverage(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (Double value : values) {
            sum += value;
        }

        return sum / values.size();
    }

    public double findMinimum(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0.0;
        }

        return Collections.min(values);
    }

    public double findMaximum(List<Double> values) {

        if (values == null || values.isEmpty()) {
            return 0.0;
        }

        return Collections.max(values);
    }
}
