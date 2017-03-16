package com.test;

public class BerlinClock {

    private Boolean topLight;

    private final Boolean[] fiveHoursLane = new Boolean[]{false, false, false, false};
    private final Boolean[] oneHourLane = new Boolean[]{false, false, false, false};
    private final Boolean[] fiveMinutesLane = new Boolean[]{false, false, false, false, false, false, false, false, false, false, false};
    private final Boolean[] oneMinuteLane = new Boolean[]{false, false, false, false};

    public BerlinClock(int hours, int minutes, int seconds) {
        validateInput(hours, minutes, seconds);
        updateTopLight(seconds);
        updateLights(fiveHoursLane, hours);
        updateRemainderLights(oneHourLane, hours);
        updateLights(fiveMinutesLane, minutes);
        updateRemainderLights(oneMinuteLane, minutes);
    }

    private void validateInput(int hours, int minutes, int seconds) {
        if (hours > 24 || hours < 0 || minutes > 59 || minutes < 0 || seconds > 59 || seconds < 0) {
            throw new IllegalArgumentException("Please provide data in a a valid time format");
        }
    }

    private void updateTopLight(int seconds) {
        topLight = seconds % 2 != 0;
    }

    private void updateLights(Boolean[] lights, int units) {
        for(int i = 0; i < units / 5; i++) {
            lights[i] = true;
        }
    }
    private void updateRemainderLights(Boolean[] lights, int units) {
        for(int i = 0; i < units % 5; i++) {
            lights[i] = true;
        }
    }

    public Boolean getTopLight() {
        return topLight;
    }

    public Boolean[] getFiveHoursLane() {
        return fiveHoursLane;
    }

    public Boolean[] getOneHourLane() {
        return oneHourLane;
    }

    public Boolean[] getFiveMinutesLane() {
        return fiveMinutesLane;
    }

    public Boolean[] getOneMinuteLane() {
        return oneMinuteLane;
    }
}
