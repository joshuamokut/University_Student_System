package com.example.demo.Utilities;

import java.time.LocalDateTime;

public class CustomTime {

    String time;

    public CustomTime(LocalDateTime time){
        CustomTimeBuilder(time.toString());
    }

    private void CustomTimeBuilder(String time) {
        this.time="";

        this.time+=time.substring(8, 10)+".";
        this.time+=time.substring(5, 7)+".";
        this.time+=time.substring(0, 4)+" ";

        this.time+=time.substring(11);
    }

    public String getTime() {
        return time;
    }
}
