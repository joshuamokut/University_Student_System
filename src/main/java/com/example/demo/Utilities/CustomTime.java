package com.example.demo.Utilities;

import java.time.LocalDateTime;

public class CustomTime {

    String time;

    protected CustomTime(LocalDateTime time){
        CustomTimeBuilder(time.toString());
    }

    private void CustomTimeBuilder(String time) {
        this.time="";

        this.time+=time.substring(8, 10)+".";
        this.time+=time.substring(5, 7)+".";
        this.time+=time.substring(0, 4)+" ";

        this.time+=time.substring(13, 18);
    }

    public String getTime() {
        return time;
    }
}
