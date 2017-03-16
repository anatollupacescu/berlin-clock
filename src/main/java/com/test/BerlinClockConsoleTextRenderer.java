package com.test;

import java.io.PrintStream;

public class BerlinClockConsoleTextRenderer implements TextRenderer<BerlinClock, PrintStream> {

    public static final String LIGHT_ON = "0";
    public static final String LIGHT_OFF = "*";

    @Override
    public void render(BerlinClock clock, PrintStream output) {
        String topLightMask =  " __________%s__________ ";
        String fourLightsMask = "__%s__ __%s__ __%s__ __%s__";
        String elevenLightsMask = "_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s_%s";
        String topLight = String.format(topLightMask, clock.getTopLight() ? LIGHT_ON : LIGHT_OFF);
        String fiveHourLights = String.format(fourLightsMask, mapToChars(clock.getFiveHoursLane()));
        String oneHourLights = String .format(fourLightsMask, mapToChars(clock.getOneHourLane()));
        String fiveMinLights = String.format(elevenLightsMask, mapMinToChars(clock.getFiveMinutesLane()));
        String oneMinLights = String.format(fourLightsMask, mapToChars(clock.getOneMinuteLane()));
        output.println(topLight);
        output.println(fiveHourLights);
        output.println(oneHourLights);
        output.println(fiveMinLights);
        output.println(oneMinLights);
        output.flush();
    }

    private Object[] mapMinToChars(Boolean[] input) {
        Object[] result = new Object[input.length];
        for(int i = 0; i < input.length; i++) {
            result[i] = input[i] ? ((i + 1) % 3 == 0 ? LIGHT_ON : "I") : "_";
        }
        return result;
    }

    private Object[] mapToChars(Boolean[] input) {
        Object[] result = new Object[input.length];
        for(int i = 0; i < input.length; i++) {
            result[i] = input[i] ? LIGHT_ON : LIGHT_OFF;
        }
        return result;
    }
}
