package com.company.entities;

//This class will be used only to get All Statuses

public class Status {
    private int statusNumber;
    private String statusName;

    public Status() {
        statusNumber = (int) Math.random();
        statusNumber = (int) (Math.floor(statusNumber * 4) + 1);
    }

    public Status(int statusNumber, String statusName) {
        this.statusNumber = statusNumber;
        this.statusName = statusName;
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public Status(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public int getStatusNumber() {
        return statusNumber;
    }

    public void setStatusNumber(int statusNumber) {
        this.statusNumber = statusNumber;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status[" +
                "statusNumber=" + statusNumber +
                ", statusName='" + statusName + '\'' +
                ']';
    }
}
