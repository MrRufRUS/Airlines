package com.ruftech.course_work.db_data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Aircraft {
    private String tailNumber, model;

    private String pattern = "yyyy-MM-dd";

    private SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

    private Date manufactureDate;
    
    private int lifetime;
    
    private int isReady;
    
    private int commanderNumber;

    public Aircraft(String tailNumber, String model, Date manufactureDate, int lifetime, int isReady, int commanderNumber) {
        this.tailNumber = tailNumber;
        this.model = model;
        this.manufactureDate = manufactureDate;
        this.lifetime = lifetime;
        this.isReady = isReady;
        this.commanderNumber = commanderNumber;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public int getIsReady() {
        return isReady;
    }

    public void setIsReady(int isReady) {
        this.isReady = isReady;
    }

    public int getCommanderPersonalNumber() {
        return commanderNumber;
    }

    public void setCommanderPersonalNumber(int commanderNumber) {
        this.commanderNumber = commanderNumber;
    }
}
