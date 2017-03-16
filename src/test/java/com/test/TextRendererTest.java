package com.test;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class TextRendererTest {

    final String expectedOutput = " __________0__________ \n" +
            "__0__ __*__ __*__ __*__\n" +
            "__0__ __0__ __*__ __*__\n" +
            "_I_I_0_I_I_0__________\n" +
            "__0__ __0__ __0__ __0__\n";

    @Test
    public void rendersOK() {
        BerlinClock berlinClock = new BerlinClock(7, 34, 19);
        TextRenderer renderer = new BerlinClockConsoleTextRenderer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        renderer.render(berlinClock, new PrintStream(outputStream));
        String output = new String(outputStream.toByteArray(), StandardCharsets.UTF_8);
        assertThat(output, is(equalTo(expectedOutput)));
    }
}