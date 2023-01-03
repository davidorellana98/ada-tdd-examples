package org.adaschool.tdd.exception;

import sun.jvm.hotspot.utilities.AssertionFailure;

public class WeatherReportNotFoundException extends RuntimeException {

    public WeatherReportNotFoundException() {
        throw new RuntimeException("Error");
    }
}
