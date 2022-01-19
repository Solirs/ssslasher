package solirsayple.sshbrutewj;

import java.time.Duration;
import java.time.Instant;

class TimeResult {
    public String day;
    public String hour;
    public String minute;
    public String second;
    public String milisecond;

    public TimeResult
    (
        int day, 
        int hour, 
        int minute, 
        int second, 
        int milisecond
    )
    {
        this.day = Integer.toString(day);
        this.hour = Integer.toString(hour);
        this.minute = Integer.toString(minute);
        this.second = Integer.toString(second);
        this.milisecond = Integer.toString(milisecond % 1000);
    }
}

public class Statistics {
    private Instant startTime = null;
    private Instant endTime = null;
    public static int attemptsCount = 0;

    
    public void start() {
        startTime = Instant.now();
    }

    public void end() {
        endTime = Instant.now();
    }

    public TimeResult timeResult() {
        Duration diff = Duration.between(startTime, endTime);
        int days = (int)diff.toDays();
        int hour = (int)diff.toHours();
        int minutes = (int)diff.toMinutes();
        int seconds = (int)diff.toSeconds();
        int miliseconds = (int)diff.toMillis();
        return new TimeResult(days, hour, minutes, seconds, miliseconds);
    }
    
}

