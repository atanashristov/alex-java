package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;

/**
 * VIN class - Unit tests getters and setters.
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alex Hristov
 * @version 1.0
 * @since 2/20/2021
 */
@DisplayName("Given a VIN instance")
public class HashTable_Lab4_VIN_GettersAndSetter_UnitTests {

    @Test
    @DisplayName("Is initialized with default data")
    public void TestIsDefault() {
        VIN vin = new VIN();
        Assertions.assertTrue(vin.isDefault());
    }

    @Test
    @DisplayName("RegionCode can be changed")
    public void TestGetSetRegionCode() {
        VIN vin = new VIN();

        vin.setRegionCode("1");
        Assertions.assertEquals("1", vin.getRegionCode());
        Assertions.assertEquals("1XXXXXXXXXXXXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("ManufacturerCode can be changed")
    public void TestGetSetManufacturerCode() {
        VIN vin = new VIN();

        vin.setManufacturerCode("11");
        Assertions.assertEquals("11", vin.getManufacturerCode());
        Assertions.assertEquals("X11XXXXXXXXXXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("VehicleDescriptor can be changed")
    public void TestGetSetVehicleDescriptor() {
        VIN vin = new VIN();

        vin.setVehicleDescriptor("12345");
        Assertions.assertEquals("12345", vin.getVehicleDescriptor());
        Assertions.assertEquals("XXX12345XXXXXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("SecurityCode can be changed")
    public void TestGetSetSecurityCode() {
        VIN vin = new VIN();

        vin.setSecurityCode("1");
        Assertions.assertEquals("1", vin.getSecurityCode());
        Assertions.assertEquals("XXXXXXXX1XXXXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("ModelYear can be changed")
    public void TestGetSetModelYear() {
        VIN vin = new VIN();

        vin.setModelYear("1");
        Assertions.assertEquals("1", vin.getModelYear());
        Assertions.assertEquals("XXXXXXXXX1XXXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("PlantCode can be changed")
    public void TestGetSetPlantCode() {
        VIN vin = new VIN();

        vin.setPlantCode("1");
        Assertions.assertEquals("1", vin.getPlantCode());
        Assertions.assertEquals("XXXXXXXXXX1XXXXXX", vin.getVIN());
    }

    @Test
    @DisplayName("SerialNumber can be changed")
    public void TestGetSetSerialNumber() {
        VIN vin = new VIN();

        vin.setSerialNumber("123456");
        Assertions.assertEquals("123456", vin.getSerialNumber());
        Assertions.assertEquals("XXXXXXXXXXX123456", vin.getVIN());
    }
}
