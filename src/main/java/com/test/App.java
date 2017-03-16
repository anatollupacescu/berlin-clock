package com.test;

import java.io.PrintStream;
import java.time.LocalDateTime;
import java.util.Date;

public class App {

    private final BerlinClock berlinClock;

    public App(int hours, int minutes, int seconds) {
        this.berlinClock = new BerlinClock(hours, minutes, seconds);
    }

    private void present(PrintStream out) {
        TextRenderer renderer = new BerlinClockConsoleTextRenderer();
        renderer.render(berlinClock, out);
    }

    public static void main(String[] args) {
        int hours;
        int minutes;
        int seconds;
        if(args.length < 3) {
            System.out.println("Time not provided, using system clock");
            LocalDateTime now = LocalDateTime.now();
            hours = now.getHour();
            minutes = now.getMinute();
            seconds = now.getSecond();
        } else {
            hours = Integer.valueOf(args[0]);
            minutes = Integer.valueOf(args[1]);
            seconds = Integer.valueOf(args[2]);
        }
        App app = new App(hours, minutes, seconds);
        app.present(System.out);
    }

}
