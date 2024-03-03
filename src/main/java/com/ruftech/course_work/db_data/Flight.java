package com.ruftech.course_work.db_data;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private String number;

    private Timestamp departureTime;

    private int isCanceled;
    private String routeNumber;
    private String aircraftTailNumber;

    public Flight(String number, Timestamp departureTime, int isCanceled, String routeNumber, String aircraftTailNumber) {
        this.number = number;
        this.departureTime = departureTime;
        this.isCanceled = isCanceled;
        this.routeNumber = routeNumber;
        this.aircraftTailNumber = aircraftTailNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    public int getIsCanceled() {
        return isCanceled;
    }

    public void setIsCanceled(int isCanceled) {
        this.isCanceled = isCanceled;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getAircraftTailNumber() {
        return aircraftTailNumber;
    }

    public void setAircraftTailNumber(String aircraftTailNumber) {
        this.aircraftTailNumber = aircraftTailNumber;
    }
}
