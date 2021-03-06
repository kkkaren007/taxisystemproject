package com.company.entities;

//This class will be used only to get All Drivers and get Driver by ID without any updating, deleting and so on

public class Drivers{
    private int driverId;
    private String driverFirstName;
    private String driverLastName;
    private long phoneNumber;
    private double driverRating;
    private boolean driverStatus;


    public Drivers(int driverId, String driverFirstName, String driverLastName, long phoneNumber, double driverRating, boolean driverStatus) {
        this.driverId = driverId;
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.phoneNumber = phoneNumber;
        this.driverRating = driverRating;
        this.driverStatus = driverStatus;
    }

    public Drivers(String driverFirstName, String driverLastName, long phoneNumber, double driverRating, boolean driverStatus) {
        this.driverFirstName = driverFirstName;
        this.driverLastName = driverLastName;
        this.phoneNumber = phoneNumber;
        this.driverRating = driverRating;
        this.driverStatus = driverStatus;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getDriverRating() {
        return driverRating;
    }

    public void setDriverRating(double driverRating) {
        this.driverRating = driverRating;
    }

    public boolean isDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(boolean driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "Drivers[" +
                "driverId=" + driverId +
                ", driverFirstName='" + driverFirstName + '\'' +
                ", driverLastName='" + driverLastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", driverRating=" + driverRating +
                ", driverStatus=" + driverStatus +
                ']';
    }
}
