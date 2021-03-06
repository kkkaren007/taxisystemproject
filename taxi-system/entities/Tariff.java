package com.company.entities;

//This class will be used only to get All Drivers and get Driver by ID without any updating, deleting and so on

public class Tariff {
    private int tariffId;
    private String serviceName;
    private double costPerKm;

    public Tariff() {
        tariffId = (int) Math.random();
        tariffId = (int) (Math.floor(tariffId * 4) + 1);
    }

    public Tariff(int tariffId, String serviceName, double costPerKm) {
        this.tariffId = tariffId;
        this.serviceName = serviceName;
        this.costPerKm = costPerKm;
    }

    public Tariff(String serviceName, double costPerKm) {
        this.serviceName = serviceName;
        this.costPerKm = costPerKm;
    }

    public Tariff(int tariffId, double costPerKm) {
        this.tariffId = tariffId;
        this.costPerKm = costPerKm;
    }

    public Tariff(int tariffId) {
        this.tariffId = tariffId;
    }

    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(double costPerKm) {
        this.costPerKm = costPerKm;
    }

    @Override
    public String toString() {
        return "Tariff[" +
                "tariffId=" + tariffId +
                ", serviceName='" + serviceName + '\'' +
                ", costPerKm=" + costPerKm +
                "] \n";
    }
}
