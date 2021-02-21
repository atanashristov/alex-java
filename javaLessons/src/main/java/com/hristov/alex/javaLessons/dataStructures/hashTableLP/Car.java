package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

/**
 * Car class.
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alex Hristov
 * @version 1.0
 * @since 2/20/2021
 */
public class Car {

    private VIN vin;

    private int year;

    private String make;

    private String country;


    public Car(String vin, int year, String make, String country) {
        this(new VIN(vin), year, make, country);
    }

    public Car(VIN vin, int year, String make, String country) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.country = country;
    }

    /**
     * Car VIN
     * @return
     */
    public VIN getVIN() {
        return vin;
    }

    public void setVIN(VIN vin) {
        this.vin = vin;
    }

    /**
     * Car year.
     */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Car make.
     */
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Car country.
     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vin='" + vin + "'" +
                ", year=" + year +
                ", make='" + make + "'" +
                ", country='" + country + "'" +
                '}';
    }
}
