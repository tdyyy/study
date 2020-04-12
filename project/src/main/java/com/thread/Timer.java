package com.thread;

import java.util.Date;

public class Timer {
    private Long timeStemp;
    public Timer (){
        this.timeStemp = new Date().getTime();
    }

    public Long duration(){
        return new Date().getTime()-this.timeStemp;
    }
}
