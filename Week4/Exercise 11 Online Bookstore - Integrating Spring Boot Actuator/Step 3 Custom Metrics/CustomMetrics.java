package com.example.bookstoreapi.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.stereotype.Component;

@Component
public class CustomMetrics implements MeterBinder {

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        meterRegistry.gauge("custom_metric", Tag.of("type", "example"), this, CustomMetrics::getCustomMetricValue);
    }

    private double getCustomMetricValue() {
        // Implement your logic to return a custom metric value
        return Math.random(); // Example: returning a random value
    }
}
