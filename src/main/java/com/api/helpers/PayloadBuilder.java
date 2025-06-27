package com.api.helpers;

public class PayloadBuilder {
    public static String flightSearchPayload(String origin, String destination, String date) {
        return String.format("{\"origin\":\"%s\",\"destination\":\"%s\",\"date\":\"%s\"}",
                origin, destination, date);
    }
}
