package com.example.demo.Utilities;

import java.time.LocalDateTime;


import static java.time.temporal.ChronoUnit.MINUTES;

public class CustomDuration {
    private String time;

    public CustomDuration(LocalDateTime start, LocalDateTime end){
        long duration=start.until(end, MINUTES);
        this.time=DurationTimeBuilder(Hours(duration), Minutes(duration));
    }


    private long Hours(long durationInMinutes){
        return durationInMinutes/60;
    }

    private long Minutes(long durationInMinutes){
        return durationInMinutes%60;
    }

    private String DurationTimeBuilder(long hours, long minutes){
        String hourPart="";
        String minutePart="";
        if (hours<10)
            hourPart+="0";

        if (minutes<10)
            minutePart+="0";

        hourPart+=Long.toString(hours);
        minutePart+=Long.toString(minutes);

        return hourPart+":"+minutePart;
    }

    public String getTime() {
        return time;
    }
}
