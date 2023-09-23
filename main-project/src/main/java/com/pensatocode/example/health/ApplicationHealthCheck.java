package com.pensatocode.example.health;

import com.codahale.metrics.health.HealthCheck;

public class ApplicationHealthCheck extends HealthCheck {

    /**
     * This simple method will return information about the healthiness of our component.
     * We could create multiple health checks, and some of them might fail in certain situations.
     * For instance, we would return Result.unhealthy() if the connection to the database failed.
     */
    @Override
    protected Result check() {
        return Result.healthy();
    }
}
