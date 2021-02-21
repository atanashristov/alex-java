package com.hristov.alex.javaLessons.dataStructures.hashTableLP;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

/**
 * VIN class - Unit tests for constructors.
 *
 * Changes:
 * - 1.0: Initial
 *
 * @author Alexander Hristov
 * @version 1.0
 * @since 2/20/2021
 */
@DisplayName("VIN objects")
public class HashTable_Lab4_VIN_Constructor_UnitTests {

    @Test
    @DisplayName("Can be constructed from VIN string")
    public void TestConstructorWithVIN() {
        VIN vin = new VIN("WMWVY77HPUW874138");

        Assertions.assertEquals("W", vin.getRegionCode());
        Assertions.assertEquals("MW", vin.getManufacturerCode());
        Assertions.assertEquals("VY77H", vin.getVehicleDescriptor());
        Assertions.assertEquals("P", vin.getSecurityCode());
        Assertions.assertEquals("U", vin.getModelYear());
        Assertions.assertEquals("W", vin.getPlantCode());
        Assertions.assertEquals("874138", vin.getSerialNumber());
    }

    @Test
    @DisplayName("Can be constructed via member-wise constructor")
    public void TestConstructorWithMemberwise() {
        VIN vin = new VIN(
                "W",
                "MW",
                "VY77H",
                "P",
                "U",
                "W",
                "874138"
        );

        Assertions.assertEquals("WMWVY77HPUW874138", vin.getVIN());
    }
}
