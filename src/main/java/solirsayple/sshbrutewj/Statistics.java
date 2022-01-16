package solirsayple.sshbrutewj;

import java.util.Dictionary;
import java.util.Hashtable;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

class TimeResult {
    public int day;
    public int hour;
    public int minute;
    public int second;
    public int milisecond;

    public TimeResult(
        int day, 
        int hour, 
        int minute, 
        int second, 
        int millisecond
    )
    {
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.milisecond = milisecond;
    }
}

public class Statistics {
    private Instant startTime = null;
    private Instant endTime = null;
    
    public void start() {
        startTime = Instant.now();
    }

    public void end() {
        endTime = Instant.now();
    }
    
    public TimeResult result() {
        Duration diff = Duration.between(startTime, endTime);
        int days = (int)diff.toDays();
        int hour = (int)diff.toHours();
        int minutes = (int)diff.toMinutes();
        int seconds = (int)diff.toSeconds();
        int miliseconds = (int)diff.toMillis();
        return new TimeResult(days, hour, minutes, seconds, miliseconds);
    }
}
