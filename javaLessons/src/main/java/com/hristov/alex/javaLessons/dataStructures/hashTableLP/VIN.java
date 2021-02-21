package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import java.util.Objects;

/**
 * VIN class - Represents a VIN (vehicle identification number).
 *
 * Changes:
 * - 1.0: Initial VIN class
 *
 * @author  Alex Hristov
 * @version 1.0
 * @since 2021-02-20
 */

public class VIN {

    private static final String DEFAULT = "XXXXXXXXXXXXXXXXX";

    private String regionCode;

    private String manufacturerCode;

    private String vehicleDescriptor;

    private String securityCode;

    private String modelYear;

    private String plantCode;

    private String serialNumber;

    /**
     * Parameterless constructor for convenience.
     * Note: sets the VIN with a default value, that is not a valid VIN number.
     */
    public VIN() {
        this(DEFAULT);
    }

    /**
     * Create an instance initialized the VIN data from a 17 character VIN string.
     * Note: Will verify the VIN string as well as it's individual segments
     *   and if verification failed, will throw exception.
     *
     * @param vinNumber the VIN string to parse.
     * @throws IllegalArgumentException Exception in case the VIN string
     *   or any of the individual segments is malformed.
     */
    public VIN(String vinNumber) {
        setVIN(vinNumber);
    }

    /**
     * Create an instance initialized the individual VIN segments
     *   passed as separate parameters.
     * Note: This is called a member-wise constructor.
     *
     * @param regionCode The VIN's 1st character: Where the vehicle was built.
     * @param manufacturerCode The VIN's 2nd and 3rd characters: The Manufacturer.
     * @param vehicleDescriptor The VIN's 4th to 8th characters: Portrait of the vehicle - brand, engine size and type.
     * @param securityCode The VIN's 9th character: Security code.
     * @param modelYear The VIN's 10th character: Model year of the car.
     * @param plantCode The VIN's 11th character: Which plant assembled the vehicle.
     * @param serialNumber The VIN's Last 6, 12th to 17th characters: serial number of the vehicle.
     */
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

    /**
     * Is this a VIN initialized with default data, which is the parameterless constructor.
     *
     * @return True if this object hold default VIN (see constant DEFAULT), false otherwise.
     */
    public boolean isDefault() {
        return getVIN().equals(DEFAULT);
    }

    @Override
    public String toString() {
        return getVIN();
    }

    /**
     * Compare to another object of it has the same VIN data.
     *
     * @param o Object to compare to this instance.
     * @return True if both objects are VIN and have the same VIN data, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Remember: Objects are sent by reference (a pointer to an address in the computer memory)
        // If the object `o` is same object (reference pointing to the same address in memory),
        // return `true`
        //
        if (this == o) return true;

        // If the object `o` is a null,
        // or if the object `o` is not a null but is an instance from some other class type,
        // return `false`.
        //
        if (o == null || getClass() != o.getClass()) return false;

        // The object `o` is not a null and it is an instance of the same class type VIN.
        // Cast to a VIN, so we can access the VIN methods and properties of that object.
        //
        VIN vin = (VIN) o;

        // Normally we compare every single member variable to verify if both objects are equal:
        //
        //        return Objects.equals(regionCode, vin.regionCode)
        //                && Objects.equals(manufacturerCode, vin.manufacturerCode)
        //                && Objects.equals(vehicleDescriptor, vin.vehicleDescriptor)
        //                && Objects.equals(securityCode, vin.securityCode)
        //                && Objects.equals(modelYear, vin.modelYear)
        //                && Objects.equals(plantCode, vin.plantCode)
        //                && Objects.equals(serialNumber, vin.serialNumber);

        // We can also use the getter methods, especially if those normalize the returned values:
        //
        //        return Objects.equals(getRegionCode(), vin.getRegionCode())
        //                && Objects.equals(getManufacturerCode(), vin.getManufacturerCode())
        //                && Objects.equals(getVehicleDescriptor(), vin.getVehicleDescriptor())
        //                && Objects.equals(getSecurityCode(), vin.getSecurityCode())
        //                && Objects.equals(getModelYear(), vin.getModelYear())
        //                && Objects.equals(getPlantCode(), vin.getPlantCode())
        //                && Objects.equals(getSerialNumber(), vin.getSerialNumber());

        // Since we already have getter for the whole VIN and it aggregates all the variables,
        // we use the VIN getter:
        //
        return Objects.equals(getVIN(), vin.getVIN());
    }

    /**
     * Get hash code.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {

        // Normally we include all the members, and use the same order as in `equals()`:
        //
        //        return Objects.hash(
        //                regionCode,
        //                manufacturerCode,
        //                vehicleDescriptor,
        //                securityCode,
        //                modelYear,
        //                plantCode,
        //                serialNumber);

        // We can also use the getter methods, especially if those normalize the returned values:
        //
        //        return Objects.hash(
        //                getRegionCode(),
        //                getManufacturerCode(),
        //                getVehicleDescriptor(),
        //                getSecurityCode(),
        //                getModelYear(),
        //                getPlantCode(),
        //                getSerialNumber());

        // Since we already have getter for the whole VIN and it aggregates all the variables,
        // we use the VIN getter:
        //
        return Objects.hash(getVIN());
    }

    /**
     * The VIN's 1st character: Where the vehicle was built.
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
     * The VIN's 2nd and 3rd characters: The Manufacturer.
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
     * The VIN's 4th to 8th characters: Portrait of the vehicle - brand, engine size and type.
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
     * The VIN's 9th character: Security code.
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
     * The VIN's 10th character: Model year of the car.
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
     * The VIN's 11th character: Which plant assembled the vehicle.
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
     * The VIN's Last 6, 12th to 17th characters: serial number of the vehicle.
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
     * The Get the complete 17 character VIN by combining the individual properties.
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

    /**
     * Set the VIN data from a 17 character VIN string.
     * This will split the VIN string and set all the individual properties.
     * Note: Will verify the VIN string as well as it's individual segments
     *   and if verification failed, will throw exception.
     *
     * @param vin the VIN string to parse.
     * @throws IllegalArgumentException Exception in case the VIN string
     *   or any of the individual segments is malformed.
     */
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

    /**
     * Null coalescing - if the string is a null, convert to an empty string.
     * It also removes the whitespace from both ends of a string.
     *
     * @param s String to normalize.
     * @return Normalized string - never a mull; whitespace from both ends is removed.
     */
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
