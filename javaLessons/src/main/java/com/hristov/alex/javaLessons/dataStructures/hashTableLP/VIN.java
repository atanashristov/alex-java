package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import java.util.Objects;

public class VIN {

    private static final String DEFAULT = "XXXXXXXXXXXXXXXXX";

    private String regionCode;

    private String manufacturerCode;

    private String vehicleDescriptor;

    private String securityCode;

    private String modelYear;

    private String plantCode;

    private String serialNumber;

    public VIN() {
        this(DEFAULT);
    }

    public VIN(String vinNumber) {
        setVIN(vinNumber);
    }

    public VIN(
            String regionCode,
            String manufacturerCode,
            String vehicleDescriptor,
            String securityCode,
            String modelYear,
            String plantCode,
            String serialNumber
    ) {
        setRegionCode(regionCode);
        setManufacturerCode(manufacturerCode);
        setVehicleDescriptor(vehicleDescriptor);
        setSecurityCode(securityCode);
        setModelYear(modelYear);
        setPlantCode(plantCode);
        setSerialNumber(serialNumber);
    }

    public boolean isDefault() {
        return getVIN().equals(DEFAULT);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VIN vin = (VIN) o;
        return Objects.equals(getVIN(), vin.getVIN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVIN());
    }

    /**
     * 1st character: Where the vehicle was built.
     * Examples: W=Germany; Z=Italy,Slovenia,...; 1,4 or 5=USA; 8,9=South America
     */
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        if (!validateRegionCode(regionCode)) {
            throw new IllegalArgumentException("Invalid region code");
        }
        this.regionCode = regionCode;
    }

    /**
     * 2nd and 3rd characters: The Manufacturer.
     */
    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        if (!validateManufacturerCode(manufacturerCode)) {
            throw new IllegalArgumentException("Invalid manufacturer code");
        }
        this.manufacturerCode = manufacturerCode;
    }

    /**
     * 4th to 8th characters: Portrait of the vehicle - brand, engine size and type.
     */
    public String getVehicleDescriptor() {
        return vehicleDescriptor;
    }

    public void setVehicleDescriptor(String vehicleDescriptor) {
        if (!validateVehicleDescriptor(vehicleDescriptor)) {
            throw new IllegalArgumentException("Invalid vehicle description");
        }
        this.vehicleDescriptor = vehicleDescriptor;
    }

    /**
     * 9th character: Security code.
     */
    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        if (!validateSecurityCode(securityCode)) {
            throw new IllegalArgumentException("Invalid security code");
        }
        this.securityCode = securityCode;
    }

    /**
     * 10th character: Model year of the car.
     */
    public String getModelYear() {
        return modelYear;
    }

    public void setModelYear(String modelYear) {
        if (!validateModelYear(modelYear)) {
            throw new IllegalArgumentException("Invalid model year");
        }
        this.modelYear = modelYear;
    }

    /**
     * 11th character: Which plant assembled the vehicle.
     */
    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        if (!validatePlantCode(plantCode)) {
            throw new IllegalArgumentException("Invalid plant code");
        }
        this.plantCode = plantCode;
    }

    /**
     * Last 6, 12th to 17th characters: serial number of the vehicle.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        if (!validateSerialNumber(serialNumber)) {
            throw new IllegalArgumentException("Invalid serial number");
        }
        this.serialNumber = serialNumber;
    }

    /**
     * The complete VIN
     */
    public String getVIN() {
        return String.join("",
                getRegionCode(),
                getManufacturerCode(),
                getVehicleDescriptor(),
                getSecurityCode(),
                getModelYear(),
                getPlantCode(),
                getSerialNumber());
    }

    public void setVIN(String vin) {
        if (!validateVIN(vin)) {
            throw new IllegalArgumentException("Invalid VIN");
        }

        int idx = 0;

        setRegionCode(vin.substring(idx, idx+1));
        idx += 1;

        setManufacturerCode(vin.substring(idx, idx+2));
        idx += 2;

        setVehicleDescriptor(vin.substring(idx, idx+5));
        idx += 5;

        setSecurityCode(vin.substring(idx, idx+1));
        idx += 1;

        setModelYear(vin.substring(idx, idx+1));
        idx += 1;

        setPlantCode(vin.substring(idx, idx+1));
        idx += 1;

        setSerialNumber(vin.substring(idx, idx+6));
        idx += 6;
    }

    private static String coalesce(String s) {
        return (s == null ? "" : s).trim();
    }

    private static Boolean validateRegionCode(String s) {
        s = coalesce(s);
        return s.length() == 1;
    }

    private static Boolean validateManufacturerCode(String s) {
        s = coalesce(s);
        return s.length() == 2;
    }

    private static Boolean validateVehicleDescriptor(String s) {
        s = coalesce(s);
        return s.length() == 5;
    }

    private static Boolean validateSecurityCode(String s) {
        s = coalesce(s);
        return s.length() == 1;
    }

    private static Boolean validateModelYear(String s) {
        s = coalesce(s);
        return s.length() == 1;
    }

    private static Boolean validatePlantCode(String s) {
        s = coalesce(s);
        return s.length() == 1;
    }

    private static Boolean validateSerialNumber(String s) {
        s = coalesce(s);
        return s.length() == 6;
    }

    private static Boolean validateVIN(String s) {
        s = coalesce(s);
        return s.length() == 17;
    }

}
