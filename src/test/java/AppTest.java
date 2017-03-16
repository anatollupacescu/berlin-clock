import com.test.BerlinClock;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void headLightComputesCorrectly() {
        int hours = 20;
        int minutes = 0;
        BerlinClock clock = new BerlinClock(hours, minutes, 0);
        assertThat(clock.getTopLight(), is(equalTo(false)));
        clock = new BerlinClock(hours, minutes, 1);
        assertThat(clock.getTopLight(), is(equalTo(true)));
    }

    @Test
    public void hoursComputesCorrectly() {
        int minutes = 0;
        int seconds = 0;
        BerlinClock clock = new BerlinClock(20, minutes, seconds);
        assertThat(clock.getFiveHoursLane(), is(equalTo(new Boolean[] {true, true, true, true})));
        assertThat(clock.getOneHourLane(), is(equalTo(new Boolean[] { false, false, false, false})));
        clock = new BerlinClock(14, minutes, seconds);
        assertThat(clock.getFiveHoursLane(), is(equalTo(new Boolean[] {true, true, false, false})));
        assertThat(clock.getOneHourLane(), is(equalTo(new Boolean[] { true, true, true, true})));
        clock = new BerlinClock(3, minutes, seconds);
        assertThat(clock.getFiveHoursLane(), is(equalTo(new Boolean[] {false, false, false, false})));
        assertThat(clock.getOneHourLane(), is(equalTo(new Boolean[] { true, true, true, false})));
    }

    @Test
    public void minutesComputesCorrectly() {
        int hours = 0;
        int seconds = 0;
        BerlinClock clock = new BerlinClock(hours, 59, seconds);
        assertThat(clock.getFiveMinutesLane(), is(equalTo(new Boolean[] { true, true, true, true, true, true, true, true, true, true, true})));
        assertThat(clock.getOneMinuteLane(), is(equalTo(new Boolean[] { true, true, true, true })));
        clock = new BerlinClock(hours, 30, seconds);
        assertThat(clock.getFiveMinutesLane(), is(equalTo(new Boolean[] { true, true, true, true, true, true, false, false, false, false, false })));
        assertThat(clock.getOneMinuteLane(), is(equalTo(new Boolean[] { false, false, false, false })));
        clock = new BerlinClock(hours, 3, seconds);
        assertThat(clock.getFiveMinutesLane(), is(equalTo(new Boolean[] { false, false, false, false, false, false, false, false, false, false, false })));
        assertThat(clock.getOneMinuteLane(), is(equalTo(new Boolean[] { true, true, true, false })));
    }
}
