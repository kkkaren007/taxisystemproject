package com.company.entities;

import static java.lang.Math.sqrt;

public class Offers extends Tariff implements Price, Distance{
    private int orderId;
    private boolean orderStatus;
    private int client;
    private double driver;
    private double car;
    private double driverStatus;
    private String addressFrom;
    private String addressTo;
    private String orderDate;

    public Offers(int tariffId, int client, double driver, double car, double driverStatus, String addressFrom, String addressTo, String orderDate) {
        super(tariffId);

        if (tariffId == 1) {
            setServiceName("Economy");
            setCostPerKm(140);
        } else if (tariffId == 2) {
            setServiceName("Comfort");
            setCostPerKm(200);
        } else if (tariffId == 3) {
            setServiceName("Comfort++");
            setCostPerKm(250);
        } else if (tariffId == 4) {
            setServiceName("Minivan");
            setCostPerKm(350);
        } else if (tariffId == 5) {
            setServiceName("Cargo");
            setCostPerKm(1000);
        } else if (tariffId == 6) {
            setServiceName("Quick");
            setCostPerKm(800);
        }

        if (driver % 3 == 0) {
            orderStatus = false;
        }
        else {
            orderStatus = true;
        }

        this.client = client;
        this.driver = driver;
        this.car = car;
        this.driverStatus = driverStatus;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.orderDate = orderDate;
    }

    public Offers(int orderId, String addressFrom) {
        this.orderId = orderId;
        this.addressFrom = addressFrom;
    }

    public Offers(int tariffId, String serviceName, double costPerKm, int orderId, boolean orderStatus, int client, double driver, double car, double driverStatus, String addressFrom, String addressTo, String orderDate) {
        super(tariffId, serviceName, costPerKm);
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.client = client;
        this.driver = driver;
        this.car = car;
        this.driverStatus = driverStatus;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.orderDate = orderDate;
    }

    public Offers(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public boolean isOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(boolean offerStatus) {
        this.orderStatus = offerStatus;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public double getCar() {
        return car;
    }

    public void setCar(double car) {
        this.car = car;
    }

    public double getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(double driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public double getDriver() {
        return driver;
    }

    public void setDriver(double driver) {
        this.driver = driver;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public double getDistance() {
        double firstCoorX = Math.random();
        firstCoorX *= 4;
        double firstCoorY = Math.random();
        firstCoorY *= 5;
        double secondCoorX = Math.random();
        secondCoorX *= 4;
        double secondCoorY = Math.random();
        secondCoorY *= 5;
        double x = secondCoorX - firstCoorX;
        double y = secondCoorY - firstCoorY;
        return sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    @Override
    public double getPrice() {
        return super.getCostPerKm() * getDistance();
    }

    @Override
    public String toString() {
        return "Offers[" +
                super.toString() +
                "orderId=" + orderId +
                ", orderStatus=" + orderStatus +
                ", client=" + client +
                ", driver=" + driver +
                ", car=" + car +
                ", driverStatus=" + driverStatus +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                ", distance=" + getDistance() +
                ", orderDate='" + orderDate + '\'' +
                ", price=" + Math.ceil(getPrice()) +
                "]";
    }
}
