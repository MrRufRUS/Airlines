package com.ruftech.course_work.db_data;

public class Route {
    private String routeNumber, departure, arrival;
    private double price;
    private int duration;

    public Route(String routeNumber, String departure, String arrival, double price, int duration) {
        this.routeNumber = routeNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
        this.duration = duration;
    }



    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
