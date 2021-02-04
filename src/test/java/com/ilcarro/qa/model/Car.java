package com.ilcarro.qa.model;

public class Car {
    private  String country;
    private  String address;
    private  String distanceIncluded;
    private  String serialNumber;
    private  String brand;
    private  String model;
    private  String year;
    private  String engine;
    private  String fuel_consumption;
    private  String fuel;
    private  String transmition;
    private  String wd;
    private  String horsepower;
    private  String torque;
    private  String doors;
    private  String seats;
    private  String carClass;
    private  String about;
    private  String typeFeature;
    private  String price;

    public Car  withCountry(String country) {
        this.country = country;
        return this;
    }

    public Car  withAddress(String address) {
        this.address = address;
        return this;

    }

    public Car  withDistanceIncluded(String distanceIncluded) {
        this.distanceIncluded = distanceIncluded;
        return this;
    }

    public Car withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }



    public Car  withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public Car  withModel(String model) {
        this.model = model;
        return this;
    }

    public Car  withYear(String year) {
        this.year = year;
        return this;
    }

    public Car  withEngine(String engine) {
        this.engine = engine;
        return this;
    }

    public Car  withFuel_consumption(String fuel_consumption) {
        this.fuel_consumption = fuel_consumption;
        return this;
    }

    public Car  withFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public Car withTransmission(String transmission) {
        this.transmition = transmission;
        return this;
    }

    public Car  withWd(String wd) {
        this.wd = wd;
        return this;
    }

    public Car  withHorsepower(String horsepower) {
        this.horsepower = horsepower;
        return this;
    }

    public Car  withTorque(String torque) {
        this.torque = torque;
        return this;
    }

    public Car  withDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public Car  withSeats(String seats) {
        this.seats = seats;
        return this;
    }


    public Car  withCarClass(String carClass) {
        this.carClass = carClass;
        return this;
    }

    public Car  withAbout(String about) {
        this.about = about;
        return this;
    }

    public Car  withTypeFeature(String typeFeature) {
        this.typeFeature = typeFeature;
        return this;
    }

    public Car  withPrice(String price) {
        this.price = price;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getDistanceIncluded() {
        return distanceIncluded;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getEngine() {
        return engine;
    }

    public String getFuel_consumption() {
        return fuel_consumption;
    }

    public String getFuel() {
        return fuel;
    }

    public String getTransmission() {
        return transmition;
    }

    public String getWd() {
        return wd;
    }

    public String getHorsepower() {
        return horsepower;
    }

    public String getTorque() {
        return torque;
    }

    public String getDoors() {
        return doors;
    }

    public String getSeats() {
        return seats;
    }


    public String getCarClass() {
        return carClass;
    }

    public String getAbout() {
        return about;
    }

    public String getTypeFeature() {
        return typeFeature;
    }

    public String getPrice() {
        return price;
    }
}
