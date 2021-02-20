package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTable_Lab4_VINUnitTests {

    @Test
    void TestIsDefault() {
        VIN vin = new VIN();
        Assertions.assertTrue(vin.isDefault());
    }

    @Test
    void TestGetSetRegionCode() {
        VIN vin = new VIN();

        vin.setRegionCode("1");
        Assertions.assertEquals("1", vin.getRegionCode());
        Assertions.assertEquals("1XXXXXXXXXXXXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetManufacturerCode() {
        VIN vin = new VIN();

        vin.setManufacturerCode("11");
        Assertions.assertEquals("11", vin.getManufacturerCode());
        Assertions.assertEquals("X11XXXXXXXXXXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetVehicleDescriptor() {
        VIN vin = new VIN();

        vin.setVehicleDescriptor("12345");
        Assertions.assertEquals("12345", vin.getVehicleDescriptor());
        Assertions.assertEquals("XXX12345XXXXXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetSecurityCode() {
        VIN vin = new VIN();

        vin.setSecurityCode("1");
        Assertions.assertEquals("1", vin.getSecurityCode());
        Assertions.assertEquals("XXXXXXXX1XXXXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetModelYear() {
        VIN vin = new VIN();

        vin.setModelYear("1");
        Assertions.assertEquals("1", vin.getModelYear());
        Assertions.assertEquals("XXXXXXXXX1XXXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetPlantCode() {
        VIN vin = new VIN();

        vin.setPlantCode("1");
        Assertions.assertEquals("1", vin.getPlantCode());
        Assertions.assertEquals("XXXXXXXXXX1XXXXXX", vin.getVIN());
    }

    @Test
    void TestGetSetSerialNumber() {
        VIN vin = new VIN();

        vin.setSerialNumber("123456");
        Assertions.assertEquals("123456", vin.getSerialNumber());
        Assertions.assertEquals("XXXXXXXXXXX123456", vin.getVIN());
    }
}
