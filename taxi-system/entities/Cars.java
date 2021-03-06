package com.company.entities;

//This class will be used only to get All Cars and get Car by ID without any updating, deleting and so on

public class Cars {
    private int carId;
    private String carBrand;
    private String carNumber;
    private int regionNumber;

    public Cars(int carId, String carBrand, String carNumber, int regionNumber) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carNumber = carNumber;
        this.regionNumber = regionNumber;
    }

    public Cars(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public int getRegionNumber() {
        return regionNumber;
    }

    public void setRegionNumber(int regionNumber) {
        this.regionNumber = regionNumber;
    }

    @Override
    public String toString() {
        return "Cars[" +
                "carId=" + carId +
                ", carBrand=" + carBrand +
                ", carNumber=" + carNumber +
                ", regionNumber=" + regionNumber +
                "] ";
    }
}
